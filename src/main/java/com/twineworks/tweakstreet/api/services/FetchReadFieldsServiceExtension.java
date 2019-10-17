package com.twineworks.tweakstreet.api.services;

import org.pf4j.ExtensionPoint;

public interface FetchReadFieldsServiceExtension extends ExtensionPoint {
  String getTypeId();
  FetchReadFieldsService newInstance();
}
