package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

public class ArrayStorageTest extends AbstractStorageTest {
  ArrayStorageTest() {
    super(new ArrayStorage());
  }

  @Test
  public void getAll() {
    Resume[] resumeArray = storage.getAll();
    for (Resume r : resumeArray) {
      assertGet(r);
    }
  }

  @Test
  public void save() {
    storage.save(R4);
    assertSize(INITIAL_ARRAY_SIZE + 1);
    assertGet(R4);
  }
}
