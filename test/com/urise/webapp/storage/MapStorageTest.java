package com.urise.webapp.storage;

public class MapStorageTest extends AbstractStorageTest {

  MapStorageTest() {
    super(new MapStorage());
  }

  @Override
  public void saveOverflow() {}
}
