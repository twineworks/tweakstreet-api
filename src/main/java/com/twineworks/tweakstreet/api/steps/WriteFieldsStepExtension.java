package com.twineworks.tweakstreet.api.steps;

import org.pf4j.ExtensionPoint;

public interface WriteFieldsStepExtension extends ExtensionPoint {
  String getTypeId();
  WriteFieldsStep newInstance();
}
