package com.twineworks.tweakstreet.api.steps.fields;

import com.twineworks.tweakflow.lang.types.Type;

public final class FieldDesc {
  public final Type type;
  public final String name;

  public FieldDesc(Type type, String name) {
    this.type = type;
    this.name = name;
  }
}
