package com.twineworks.tweakstreet.api.steps;

import com.twineworks.tweakflow.lang.values.ValueProvider;
import com.twineworks.tweakstreet.api.steps.hub.Hub;
import com.twineworks.tweakstreet.api.steps.results.ResultDesc;
import com.twineworks.tweakstreet.api.steps.settings.SettingDesc;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePassThroughStep implements PassThroughStep {

  protected Logger log;
  protected Hub hub;

  @Override
  public void setHub(Hub hub) {
    this.hub = hub;
  }

  @Override
  public void setLogger(Logger log) {
    this.log = log;
  }

  @Override
  public List<ResultDesc> getDeclaredResults() {
    return Collections.emptyList();
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

  @Override
  public Map<String, ValueProvider> getResultProviders(Set<String> names) {
    return Collections.emptyMap();
  }

  @Override
  public void initProcessing() {
  }

  @Override
  public void shutdown() {
  }

}
