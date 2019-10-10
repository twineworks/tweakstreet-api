package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.ListValue;
import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class ListSetting implements ValueProvider {

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

    public ListSetting build(){
      return new ListSetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private ListValue lastRet;

  private ListSetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public ListValue get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    ListValue num;
    if (nullable){
      num = Utils.asList(name, value);
      if (num == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      num = Utils.asNNList(name, value);
    }

    lastRet = num;
    lastRetSet = true;
    return num;

  }

  public boolean hasChanged(){
    return !lastRetSet || (valueProvider.getValue() != value);
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
