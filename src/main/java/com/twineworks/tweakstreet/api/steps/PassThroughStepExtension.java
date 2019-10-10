package com.twineworks.tweakstreet.api.steps;

import org.pf4j.ExtensionPoint;

public interface PassThroughStepExtension extends ExtensionPoint {
  String getTypeId();
  PassThroughStep newInstance();
}
