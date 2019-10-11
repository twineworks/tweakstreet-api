package com.twineworks.tweakstreet.api.steps.hub;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakstreet.api.fs.FileSystemConnection;

public interface Hub {
  FileSystemConnection fileSystemConnection(Value def);
  StepInfo getStepInfo();
  FlowInfo getFlowInfo();
}
