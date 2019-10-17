package com.twineworks.tweakstreet.api.services;

import com.twineworks.tweakstreet.api.desc.readfields.ReadFieldDesc;

import java.util.List;

public interface FetchReadFieldsService extends StepService {
  List<ReadFieldDesc> fetchReadFields();
}
