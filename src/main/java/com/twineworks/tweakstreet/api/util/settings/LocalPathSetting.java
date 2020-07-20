package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public final class LocalPathSetting implements ValueProvider {

  public final static class Builder {

    private String name;
    private ValueProvider valueProvider;
    private boolean nullable = false;

    public Builder(String name){
      this.name = name;
    }

    public Builder from(Map<String, ValueProvider> settings){
      this.valueProvider = settings.get(name);
      return this;
    }

    public Builder nullable(){
      this.nullable = true;
      return this;
    }

    public Builder nullable(boolean nullable){
      this.nullable = nullable;
      return this;
    }

    public LocalPathSetting build(){
      return new LocalPathSetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private Path lastRet;

  private LocalPathSetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public Path get(String rel){
    return get(Paths.get(rel));
  }

  public Path get(Path rel){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    String str;
    if (nullable){
      str = Utils.asString(name, value);
      if (str == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      str = Utils.asNNString(name, value);
    }

    Path p;
    if (str.startsWith(".")) {
      p = rel.resolveSibling(str).normalize();
    } else {
      p = Paths.get(str);
    }

    lastRet = p;
    lastRetSet = true;
    return p;

  }

  public boolean hasChanged(){
    return !lastRetSet || (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
