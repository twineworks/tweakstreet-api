package com.twineworks.tweakstreet.api.util.settings;

import com.twineworks.tweakflow.lang.errors.LangException;
import com.twineworks.tweakflow.lang.types.Types;
import com.twineworks.tweakflow.lang.values.*;

import java.math.BigDecimal;

final class Utils {

  static String asString(String name, Value v){
    if (v.isNil()) return null;
    if (v.isString()) return v.string();
    try {
      return v.castTo(Types.STRING).string();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a string, or cast to string, found: "+ ValueInspector.inspect(v));
    }
  }

  static String asNNString(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isString()) return v.string();
    try {
      return v.castTo(Types.STRING).string();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a string, or cast to string, found: "+ ValueInspector.inspect(v));
    }
  }

  static byte[] asBytes(String name, Value v){
    if (v.isNil()) return null;
    if (v.isBinary()) return v.bytes();
    try {
      return v.castTo(Types.BINARY).bytes();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a binary, or cast to binary, found: "+ ValueInspector.inspect(v));
    }
  }

  static byte[] asNNBytes(String name, Value v){
    if (v.isNil()) throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    if (v.isBinary()) return v.bytes();
    try {
      return v.castTo(Types.BINARY).bytes();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a binary, or cast to binary, found: "+ ValueInspector.inspect(v));
    }
  }

  static <T extends Enum<T>> T asNNEnum(String name, Value v, Class<T> tEnum){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    String str;
    try {
      str = v.castTo(Types.STRING).string();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a string, or cast to string, found: "+ ValueInspector.inspect(v));
    }

    T t = Enum.valueOf(tEnum, str.toUpperCase());
    return t;
  }

  static Long asLong(String name, Value v){
    if (v.isNil()) return null;
    if (v.isLongNum()) return v.longNum();
    try {
      return v.castTo(Types.LONG).longNum();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a long, or cast to long, found: "+ ValueInspector.inspect(v));
    }
  }

  static long asNNLong(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isLongNum()) return v.longNum();
    try {
      return v.castTo(Types.LONG).longNum();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a long, or cast to long, found: "+ ValueInspector.inspect(v));
    }
  }

  static Integer asInteger(String name, Value v){
    if (v.isNil()) return null;
    long min = Integer.MIN_VALUE;
    long max = Integer.MAX_VALUE;
    long n;
    if (v.isLongNum()){
      n = v.longNum();
    }
    else{
      try {
        n = v.castTo(Types.LONG).longNum();
      } catch (LangException e){
        throw new IllegalArgumentException(name +" must be a long, or cast to long, found: "+ ValueInspector.inspect(v));
      }
    }

    if (n >= min && n <= max){
      return (int) n;
    } else {
      throw new IllegalArgumentException(name +" must be a long between "+min+" and "+max+", found: "+ ValueInspector.inspect(v));
    }

  }

  static Integer asNNInteger(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    return asInteger(name, v);
  }

  static Boolean asBoolean(String name, Value v){
    if (v.isNil()) return null;
    if (v.isBoolean()) return v.bool();
    try {
      return v.castTo(Types.BOOLEAN).bool();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a boolean, or cast to boolean, found: "+ ValueInspector.inspect(v));
    }
  }

  static Boolean asNNBoolean(String name, Value v){

    if (v.isNil()) throw new IllegalArgumentException(name +" must be non-nil, found: nil");;
    if (v.isBoolean()) return v.bool();
    try {
      return v.castTo(Types.BOOLEAN).bool();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a boolean, or cast to boolean, found: "+ ValueInspector.inspect(v));
    }
  }

  static Double asDouble(String name, Value v){
    if (v.isNil()) return null;
    if (v.isDoubleNum()) return v.doubleNum();
    try {
      return v.castTo(Types.DOUBLE).doubleNum();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a double, or cast to double, found: "+ ValueInspector.inspect(v));
    }
  }

  static Double asNNDouble(String name, Value v){
    if (v.isNil()) throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    if (v.isDoubleNum()) return v.doubleNum();
    try {
      return v.castTo(Types.DOUBLE).doubleNum();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a double, or cast to double, found: "+ ValueInspector.inspect(v));
    }
  }

  static BigDecimal asBigDecimal(String name, Value v){
    if (v.isNil()) return null;
    if (v.isDecimal()) return v.decimal();
    try {
      return v.castTo(Types.DECIMAL).decimal();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a decimal, or cast to decimal, found: "+ ValueInspector.inspect(v));
    }
  }

  static BigDecimal asNNBigDecimal(String name, Value v){
    if (v.isNil()) throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    if (v.isDecimal()) return v.decimal();
    try {
      return v.castTo(Types.DECIMAL).decimal();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a decimal, or cast to decimal, found: "+ ValueInspector.inspect(v));
    }
  }

  static DateTimeValue asDatetime(String name, Value v){
    if (v.isNil()) return null;
    if (v.isDateTime()) return v.dateTime();
    try {
      return v.castTo(Types.DATETIME).dateTime();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a datetime, or cast to datetime, found: "+ ValueInspector.inspect(v));
    }
  }

  static DateTimeValue asNNDatetime(String name, Value v) {
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isDateTime()) return v.dateTime();
    try {
      return v.castTo(Types.DATETIME).dateTime();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a datetime, or cast to datetime, found: "+ ValueInspector.inspect(v));
    }
  }

  static DictValue asDict(String name, Value v){
    if (v.isNil()) return null;
    if (v.isDict()) return v.dict();
    try {
      return v.castTo(Types.DICT).dict();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a dict, or cast to dict, found: "+ ValueInspector.inspect(v));
    }
  }

  static DictValue asNNDict(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isDict()) return v.dict();
    try {
      return v.castTo(Types.DICT).dict();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a dict, or cast to dict, found: "+ ValueInspector.inspect(v));
    }
  }

  static ListValue asList(String name, Value v){
    if (v.isNil()) return null;
    if (v.isList()) return v.list();
    try {
      return v.castTo(Types.LIST).list();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a list, or cast to list, found: "+ ValueInspector.inspect(v));
    }
  }

  static ListValue asNNList(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isList()) return v.list();
    try {
      return v.castTo(Types.LIST).list();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a list, or cast to list, found: "+ ValueInspector.inspect(v));
    }
  }

  static FunctionValue asFunction(String name, Value v){
    if (v.isNil()) return null;
    if (v.isFunction()) return v.function();
    try {
      return v.castTo(Types.FUNCTION).function();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a function, or cast to function, found: "+ ValueInspector.inspect(v));
    }
  }

  static FunctionValue asNNFunction(String name, Value v){
    if (v.isNil()){
      throw new IllegalArgumentException(name +" must be non-nil, found: nil");
    }
    if (v.isFunction()) return v.function();
    try {
      return v.castTo(Types.FUNCTION).function();
    } catch (LangException e){
      throw new IllegalArgumentException(name +" must be a function, or cast to function, found: "+ ValueInspector.inspect(v));
    }
  }

}
