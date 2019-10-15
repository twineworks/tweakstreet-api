package com.twineworks.tweakstreet.api.steps;

import org.pf4j.ExtensionPoint;

public interface ReadFieldsStepExtension extends ExtensionPoint {
  String getTypeId();
  ReadFieldsStep newInstance();
}
