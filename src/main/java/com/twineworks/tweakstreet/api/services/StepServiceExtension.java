package com.twineworks.tweakstreet.api.services;

import org.pf4j.ExtensionPoint;

public interface StepServiceExtension extends ExtensionPoint {
  String getTypeId();
  StepService newInstance();
}
