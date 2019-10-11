package com.twineworks.tweakstreet.api.fs.traversal;

import com.twineworks.tweakstreet.api.fs.StorageFileInfo;

import java.io.IOException;

public interface StorageVisitor {
  StorageVisitResult preVisitDirectory(String dir, StorageFileInfo attrs) throws IOException;
  StorageVisitResult visitFile(String file, StorageFileInfo attrs) throws IOException;
  StorageVisitResult visitFileFailed(String file, IOException exc) throws IOException;
  StorageVisitResult postVisitDirectory(String dir, IOException exc) throws IOException;
}
