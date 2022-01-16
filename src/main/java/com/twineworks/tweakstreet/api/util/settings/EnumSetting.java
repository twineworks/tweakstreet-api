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
    private T defaultIfNull = null;

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

    public Builder<T> defaultIfNull(T defaultIfNull){
      this.defaultIfNull = defaultIfNull;
      return this;
    }

    public EnumSetting<T> build(){
      if (!nullable && defaultIfNull != null){
        throw new AssertionError("defaultIfNull has been supplied, nullable must be true in this case");
      }
      return new EnumSetting<>(name, valueProvider, tEnum, nullable, defaultIfNull);
    }

  }

  private final ValueProvider valueProvider;
  private final String name;
  private final boolean nullable;

  private Value value;
  private boolean lastRetSet = false;
  private final Class<T> tEnum;
  private T lastRet;
  private final T defaultIfNull;

  private EnumSetting(String name, ValueProvider valueProvider, Class<T> tEnum, boolean nullable, T defaultIfNull) {
    this.valueProvider = valueProvider;
    this.name = name;
    this.tEnum = tEnum;
    this.nullable = nullable;
    this.defaultIfNull = defaultIfNull;
  }

  public T get(){

    if (!hasChanged()) return lastRet;

    lastRetSet = false;

    value = valueProvider.getValue();

    String enumName;

    if (nullable){
      enumName = Utils.asString(name, value);
      if (enumName == null){
        lastRet = defaultIfNull;
        lastRetSet = true;
        return defaultIfNull;
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
    return !lastRetSet || (!valueProvider.getValue().equals(value));
  }

  @Override
  public Value getValue() {
    return valueProvider.getValue();
  }

}
