package com.twineworks.tweakstreet.api.steps;

import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.steps.context.StepContext;
import com.twineworks.tweakstreet.api.desc.results.ResultDesc;
import com.twineworks.tweakstreet.api.desc.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePassThroughStep implements PassThroughStep {

  protected Logger log;
  protected StepContext context;

  @Override
  public void setContext(StepContext context) {
    this.context = context;
  }

  @Override
  public void setLogger(Logger log) {
    this.log = log;
  }

  @Override
  public void setSettingProviders(Map<String, ValueProvider> settings) {

  }

  @Override
  public void setStaticSettingProviders(Map<String, ValueProvider> settings) {

  }

  @Override
  public Map<String, ValueProvider> getResultProviders(Set<String> names) {
    return Collections.emptyMap();
  }

  @Override
  public void initProcessing() {
  }

  @Override
  public void finishProcessing() {
  }

  @Override
  public void shutdown() {
  }

}
