package com.twineworks.tweakstreet.api.fs;

import com.twineworks.tweakflow.lang.values.Value;

import java.time.Instant;

public interface StorageFileInfo {
  String getPath();
  String getName();
  String getParentPath();
  Long size();
  boolean isFile();
  boolean isDirectory();
  boolean isSymbolicLink();
  boolean isOther();
  Instant getLastModifiedTime();
  Instant getCreationTime();

  Value toValue();
}
