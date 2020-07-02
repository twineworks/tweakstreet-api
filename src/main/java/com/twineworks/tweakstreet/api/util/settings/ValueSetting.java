package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class ValueSetting implements ValueProvider {

  public final static class Builder {

    private String name;
    private ValueProvider valueProvider;

    public Builder(String name){
      this.name = name;
    }

    public Builder from(Map<String, ValueProvider> settings){
      this.valueProvider = settings.get(name);
      return this;
    }

    public ValueSetting build(){
      return new ValueSetting(name, valueProvider);
    }

  }

  private final ValueProvider valueProvider;
  private final String name;

  private Value value;

  private ValueSetting(String name, ValueProvider valueProvider) {
    this.valueProvider = valueProvider;
    this.name = name;
  }

  public Value get(){

    if (!hasChanged()) return value;

    value = valueProvider.getValue();
    return value;

  }

  public boolean hasChanged(){
    return (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
