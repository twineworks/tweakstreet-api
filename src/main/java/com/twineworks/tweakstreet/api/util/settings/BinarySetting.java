package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class BinarySetting implements ValueProvider {

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

    public BinarySetting build(){
      return new BinarySetting(name, valueProvider, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final boolean nullable;
  private final String name;

  private Value value;
  private boolean lastRetSet = false;
  private byte[] lastRet;

  private BinarySetting(String name, ValueProvider valueProvider, boolean nullable) {
    this.valueProvider = valueProvider;
    this.nullable = nullable;
    this.name = name;
  }

  public byte[] get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();
    byte[] bin;
    if (nullable){
      bin = Utils.asBytes(name, value);
      if (bin == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else {
      bin = Utils.asNNBytes(name, value);
    }

    lastRet = bin;
    lastRetSet = true;
    return bin;

  }

  public boolean hasChanged(){
    return !lastRetSet || (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
