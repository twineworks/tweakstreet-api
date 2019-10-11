package com.twineworks.tweakstreet.api.fs.traversal;

public enum StorageVisitResult {
  CONTINUE,
  TERMINATE,
  SKIP_SUBTREE,
  SKIP_SIBLINGS
}
