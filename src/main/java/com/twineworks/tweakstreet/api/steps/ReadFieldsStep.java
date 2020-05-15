package com.twineworks.tweakstreet.api.steps;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.steps.context.StepContext;
import com.twineworks.tweakstreet.api.desc.mappings.Mapping;
import com.twineworks.tweakstreet.api.desc.results.ResultDesc;
import com.twineworks.tweakstreet.api.desc.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReadFieldsStep extends DataFlowLoopOk {

  void setLogger(Logger log);
  void setContext(StepContext context);

  List<ResultDesc> getDeclaredResults();
  List<SettingDesc> getDeclaredSettings();
  List<SettingDesc> getDeclaredStaticSettings();
  void setSettingProviders(Map<String, ValueProvider> settings);
  void setStaticSettingProviders(Map<String, ValueProvider> settings);
  Map<String, ValueProvider> getResultProviders(Set<String> names);

  void initProcessing();

  void open(List<Mapping> mappings);
  boolean readNextRow();
  void getRowFields(Value[] fields);

  void shutdown();

}
