package com.twineworks.tweakstreet.api.services;

import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.services.context.StepServiceContext;
import com.twineworks.tweakstreet.api.desc.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;

public interface StepService {

  void setLogger(Logger log);
  void setContext(StepServiceContext context);

  List<SettingDesc> getDeclaredSettings();
  List<SettingDesc> getDeclaredStaticSettings();

  void setSettingProviders(Map<String, ValueProvider> settings);
  void setStaticSettingProviders(Map<String, ValueProvider> settings);

}
