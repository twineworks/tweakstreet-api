package com.twineworks.tweakstreet.api.services;

import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.services.context.StepServiceContext;
import com.twineworks.tweakstreet.api.desc.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class BaseStepService implements StepService {

  protected Logger log;
  protected StepServiceContext context;

  @Override
  public void setLogger(Logger log) {
    this.log = log;
  }

  @Override
  public void setContext(StepServiceContext context) {
    this.context = context;
  }

  @Override
  public List<SettingDesc> getDeclaredSettings() {
    return Collections.emptyList();
  }

  @Override
  public List<SettingDesc> getDeclaredStaticSettings() {
    return Collections.emptyList();
  }

  @Override
  public void setSettingProviders(Map<String, ValueProvider> settings) {
  }

  @Override
  public void setStaticSettingProviders(Map<String, ValueProvider> settings) {
  }

}
