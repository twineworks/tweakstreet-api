package com.twineworks.tweakstreet.api.fs.traversal;

import com.twineworks.tweakstreet.api.fs.StorageFileInfo;

import java.io.IOException;

public interface StorageMatcher {
  boolean matches(String path, StorageFileInfo attrs) throws IOException;
}
