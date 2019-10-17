package com.twineworks.tweakstreet.api.desc.mappings;

public final class IndexedMappingDesc implements MappingDesc {

  private final String type = "index";
  public final int index;

  public IndexedMappingDesc(int index) {
    this.index = index;
  }
}
