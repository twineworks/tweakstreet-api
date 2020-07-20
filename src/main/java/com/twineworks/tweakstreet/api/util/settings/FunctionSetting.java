package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.FunctionValue;
import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.math.BigDecimal;
import java.util.Map;

public final class FunctionSetting implements ValueProvider {

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

    public FunctionSetting build(){
      return new FunctionSetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private FunctionValue lastRet;

  private FunctionSetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public FunctionValue get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    FunctionValue f;
    if (nullable){
      f = Utils.asFunction(name, value);
      if (f == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      f = Utils.asNNFunction(name, value);
    }

    lastRet = f;
    lastRetSet = true;
    return f;

  }

  public boolean hasChanged(){
    return !lastRetSet || (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
