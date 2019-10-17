package com.twineworks.tweakstreet.api.desc.mappings;

public final class StringMappingDesc implements MappingDesc {

  private final String type = "string";
  public final String mapping;

  public StringMappingDesc(String mapping) {
    this.mapping = mapping;
  }
}
