package com.twineworks.tweakstreet.api.fs;

import com.twineworks.tweakstreet.api.fs.traversal.StorageMatcher;
import com.twineworks.tweakstreet.api.fs.traversal.StorageVisitor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.LinkOption;
import java.util.List;

public interface FileSystemConnection extends AutoCloseable {
  InputStream newInputStream(String path, int bufferSize) throws IOException;
  BufferedReader newBufferedReader(String path, Charset charset, int bufferSize) throws IOException;
  BufferedWriter newBufferedWriter(String path, Charset charset, int bufferSize, WriteOpenExistingOption ifExists) throws IOException;
  OutputStream newOutputStream(String path, int bufferSize, WriteOpenExistingOption ifExists) throws IOException;
  boolean isRegularFile(String path, LinkOption... options) throws IOException;
  boolean isDirectory(String path, LinkOption... options) throws IOException;
  void walkFileTree(String path, int maxDepth, StorageVisitor v) throws IOException;
  StorageMatcher newMatcher(String pattern) throws IOException;
  String relNorm(String at, String path) throws IOException;
  boolean exists(String path) throws IOException;
  StorageFileInfo fileInfo(String path) throws IOException;
  String resolve(String base, String name) throws IOException;
  List<StorageFileInfo> getChildren(String path) throws IOException;
  void mkParentFor(String path) throws IOException;
  void mkDir(String path) throws IOException;
  void rmTree(String path) throws IOException;
  String textContent(String path, Charset charset) throws IOException;
  byte[] binContent(String path, Integer limit) throws IOException;
  void putContent(String path, InputStream is) throws IOException;
  void copy(String source, String target, boolean replace) throws IOException;
  void move(String src, String dst, boolean replace) throws IOException;
  void close() throws IOException;
}
