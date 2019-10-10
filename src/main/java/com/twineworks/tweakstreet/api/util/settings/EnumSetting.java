package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;

import java.util.Map;

public final class EnumSetting<T extends Enum<T>> implements ValueProvider {

  public final static class Builder<T extends Enum<T>> {

    private String name;
    private ValueProvider valueProvider;
    private Class<T> tEnum;
    private boolean nullable = false;

    public Builder(String name){
      this.name = name;
    }

    public Builder<T> from(Map<String, ValueProvider> settings){
      this.valueProvider = settings.get(name);
      return this;
    }

    public Builder<T> ofEnum(Class<T> tEnum){
      this.tEnum = tEnum;
      return this;
    }

    public Builder<T> nullable(){
      this.nullable = true;
      return this;
    }

    public Builder<T> nullable(boolean nullable){
      this.nullable = nullable;
      return this;
    }

    public EnumSetting<T> build(){
      return new EnumSetting<>(name, valueProvider, tEnum, nullable);
    }

  }

  private final ValueProvider valueProvider;
  private final String name;
  private final boolean nullable;

  private Value value;
  private boolean lastRetSet = false;
  private Class<T> tEnum;
  private T lastRet;

  private EnumSetting(String name, ValueProvider valueProvider, Class<T> tEnum, boolean nullable) {
    this.valueProvider = valueProvider;
    this.name = name;
    this.tEnum = tEnum;
    this.nullable = nullable;
  }

  public T get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();

    String enumName;

    if (nullable){
      enumName = Utils.asString(name, value);
      if (enumName == null){
        lastRet = null;
        lastRetSet = true;
        return null;
      }
    }
    else{
      enumName = Utils.asNNString(name, value);
    }

    T anEnum = Enum.valueOf(tEnum, enumName.toUpperCase());

    lastRet = anEnum;
    lastRetSet = true;
    return anEnum;

  }

  public boolean hasChanged(){
    return !lastRetSet || (valueProvider.getValue() != value);
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
