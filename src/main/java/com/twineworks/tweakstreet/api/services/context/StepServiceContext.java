package com.twineworks.tweakstreet.api.services.context;

import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakstreet.api.fs.FileSystemConnection;
import com.twineworks.tweakstreet.api.steps.context.FlowInfo;

public interface StepServiceContext {
  FileSystemConnection fileSystemConnection(Value def);
  FlowInfo getFlowInfo();
}
