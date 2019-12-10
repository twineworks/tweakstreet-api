package com.twineworks.tweakstreet.api.desc.readfields;

import com.twineworks.tweakflow.lang.types.Type;
import com.twineworks.tweakstreet.api.desc.expressions.ExpressionDesc;
import com.twineworks.tweakstreet.api.desc.mappings.MappingDesc;

public final class ReadFieldDesc {
  public Type type;
  public String name;
  public MappingDesc mapping;
  public ExpressionDesc conversion;

  public ReadFieldDesc(Type type, String name, MappingDesc mapping, ExpressionDesc conversion) {
    this.type = type;
    this.name = name;
    this.mapping = mapping;
    this.conversion = conversion;
  }
}
