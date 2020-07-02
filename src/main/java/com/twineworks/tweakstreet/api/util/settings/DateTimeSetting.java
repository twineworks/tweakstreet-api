package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.DateTimeValue;
import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class DateTimeSetting implements ValueProvider {

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

    public DateTimeSetting build(){
      return new DateTimeSetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private DateTimeValue lastRet;

  private DateTimeSetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public DateTimeValue get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    DateTimeValue d;
    if (nullable){
      d = Utils.asDatetime(name, value);
      if (d == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      d = Utils.asNNDatetime(name, value);
    }

    lastRet = d;
    lastRetSet = true;
    return d;

  }

  public boolean hasChanged(){
    return !lastRetSet || (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
