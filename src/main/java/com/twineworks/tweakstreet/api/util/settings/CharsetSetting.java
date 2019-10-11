package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.nio.charset.Charset;
import java.util.Map;

public final class CharsetSetting implements ValueProvider {

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

    public CharsetSetting build(){
      return new CharsetSetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private Charset lastRet;

  private CharsetSetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public Charset get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    String charsetName;
    if (nullable){
      charsetName = Utils.asString(name, value);
      if (charsetName == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      charsetName = Utils.asNNString(name, value);
    }

    lastRet = Charset.forName(charsetName);
    lastRetSet = true;
    return lastRet;

  }

  public boolean hasChanged(){
    return !lastRetSet || (valueProvider.getValue() != value);
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
