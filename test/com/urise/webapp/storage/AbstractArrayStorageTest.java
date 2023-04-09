package com.urise.webapp.storage;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Test;

public class AbstractArrayStorageTest extends AbstractStorageTest {

  AbstractArrayStorageTest(Storage storage) {
    super(storage);
  }

  @Test
  public void saveOverflow() {
    storage.clear();
    assertThrows(
        StorageException.class,
        () -> {
          int i = 0;
          try {
            for (; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
              storage.save(new Resume("uuid" + i));
            }
          } catch (StorageException e) {
            if (i == AbstractArrayStorage.STORAGE_LIMIT) {
              throw e;
            } else {
              System.out.println("StorageException is thrown earlier than expected");
            }
          }
        });
  }
}
