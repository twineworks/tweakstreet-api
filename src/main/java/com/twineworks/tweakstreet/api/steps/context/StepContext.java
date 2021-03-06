package com.twineworks.tweakstreet.api.steps.context;

import com.twineworks.tweakflow.lang.interpreter.CallContext;
import com.twineworks.tweakflow.lang.values.Value;
import com.twineworks.tweakstreet.api.fs.FileSystemConnection;

public interface StepContext {
  FileSystemConnection fileSystemConnection(Value def);
  CallContext createCallContext();
  FlowInfo getFlowInfo();
}
