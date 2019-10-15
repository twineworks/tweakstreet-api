package com.twineworks.tweakstreet.api.steps.mappings;

import com.twineworks.tweakflow.lang.values.Value;

public final class MappingDesc {
  public final String name;
  public final Value mapping;

  public MappingDesc(String name, Value mapping) {
    this.name = name;
    this.mapping = mapping;
  }
}
