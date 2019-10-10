package com.twineworks.tweakstreet.api.steps.results;

import com.twineworks.tweakflow.lang.types.Type;

public final class ResultDesc {
  public final Type type;
  public final String name;

  public ResultDesc(Type type, String name) {
    this.type = type;
    this.name = name;
  }
}
