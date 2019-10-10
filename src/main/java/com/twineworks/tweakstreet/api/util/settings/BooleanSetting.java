package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class BooleanSetting implements ValueProvider {

  public final static class Builder {

    private String name;
    private ValueProvider valueProvider;
    private boolean nullable = false;
    private boolean nilIsFalse = false;

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

    public Builder nilIsFalse(){
      this.nullable = true;
      this.nilIsFalse = true;
      return this;
    }

    public BooleanSetting build(){
      return new BooleanSetting(name, valueProvider, nullable, nilIsFalse);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private final boolean nilIsFalse;

  private Value value;
  private boolean lastRetSet = false;
  private Boolean lastRet;

  private BooleanSetting(String name, ValueProvider valueProvider, boolean nullable, boolean nilIsFalse) {
    this.name = name;
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.nilIsFalse = nilIsFalse;
  }

  public Boolean get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    Boolean b;
    if (nullable){
      b = Utils.asBoolean(name, value);
      if (b == null){
        if (nilIsFalse){
          lastRet = Boolean.FALSE;
          lastRetSet = true;
          return Boolean.FALSE;
        }
        else{
          lastRet = null;
          lastRetSet = true;
          return null;
        }
      }
    }
    else {
      b = Utils.asNNBoolean(name, value);
    }

    lastRet = b;
    lastRetSet = true;
    return b;

  }

  public boolean isTrue(){
    return get() == Boolean.TRUE;
  }

  public boolean hasChanged(){
    return !lastRetSet || (valueProvider.getValue() != value);
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
