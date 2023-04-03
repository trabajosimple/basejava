package com.urise.webapp.storage;

public class ListStorageTest extends AbstractStorageTest {

  ListStorageTest() {
    super(new ListStorage());
  }

  @Override
  public void saveOverflow() {}
}
