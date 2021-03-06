package com.twineworks.tweakstreet.api.steps;

import com.twineworks.tweakstreet.api.desc.results.ResultDesc;
import com.twineworks.tweakstreet.api.desc.settings.SettingDesc;
import org.pf4j.ExtensionPoint;

import java.util.List;

public interface WriteFieldsStepExtension extends ExtensionPoint {
  String getTypeId();
  WriteFieldsStep newInstance();

  List<ResultDesc> getDeclaredResults();
  List<SettingDesc> getDeclaredSettings();
  List<SettingDesc> getDeclaredStaticSettings();
}
