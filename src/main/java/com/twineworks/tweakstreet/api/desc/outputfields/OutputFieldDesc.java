package com.twineworks.tweakstreet.api.desc.outputfields;

import com.twineworks.tweakflow.lang.types.Type;
import com.twineworks.tweakstreet.api.desc.expressions.ExpressionDesc;
import com.twineworks.tweakstreet.api.desc.mappings.MappingDesc;

public final class OutputFieldDesc {
  public Type type;
  public String name;
  public ExpressionDesc value;

  public OutputFieldDesc(Type type, String name, ExpressionDesc value) {
    this.type = type;
    this.name = name;
    this.value = value;
  }
}
