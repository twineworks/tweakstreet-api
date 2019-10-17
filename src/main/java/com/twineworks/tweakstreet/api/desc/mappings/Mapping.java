package com.twineworks.tweakstreet.api.desc.mappings;

import com.twineworks.tweakflow.lang.values.Value;

public final class Mapping {
  public final String name;
  public final Value mapping;

  public Mapping(String name, Value mapping) {
    this.name = name;
    this.mapping = mapping;
  }
}
