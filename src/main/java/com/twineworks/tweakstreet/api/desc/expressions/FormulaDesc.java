package com.twineworks.tweakstreet.api.desc.expressions;

public class FormulaDesc implements ExpressionDesc {
  public final String type = "formula";
  public final String code;

  public FormulaDesc(String code) {
    this.code = code;
  }

}
