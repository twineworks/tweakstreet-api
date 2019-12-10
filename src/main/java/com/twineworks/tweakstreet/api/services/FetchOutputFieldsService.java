package com.twineworks.tweakstreet.api.services;

import com.twineworks.tweakstreet.api.desc.outputfields.OutputFieldDesc;
import com.twineworks.tweakstreet.api.desc.readfields.ReadFieldDesc;

import java.util.List;

public interface FetchOutputFieldsService extends StepService {
  List<OutputFieldDesc> fetchOutputFields();
}
