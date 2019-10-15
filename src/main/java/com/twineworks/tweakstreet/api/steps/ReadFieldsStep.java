package com.twineworks.tweakstreet.api.steps;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.steps.hub.Hub;
import com.twineworks.tweakstreet.api.steps.mappings.MappingDesc;
import com.twineworks.tweakstreet.api.steps.results.ResultDesc;
import com.twineworks.tweakstreet.api.steps.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReadFieldsStep {

  void setLogger(Logger log);
  void setHub(Hub hub);

  List<ResultDesc> getDeclaredResults();
  List<SettingDesc> getDeclaredSettings();
  List<SettingDesc> getDeclaredStaticSettings();
  void setSettingProviders(Map<String, ValueProvider> settings);
  void setStaticSettingProviders(Map<String, ValueProvider> settings);
  Map<String, ValueProvider> getResultProviders(Set<String> names);

  void initProcessing();

  void open(List<MappingDesc> mappings);
  boolean readNextRow();
  void getRowFields(Value[] fields);

  void shutdown();

}
