package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractStorageTest {
  protected static final String UUID_1 = "uuid0";
  protected static final String UUID_2 = "uuid1";
  protected static final String UUID_3 = "uuid2";
  protected static final Resume R1 = new Resume(UUID_1);
  protected static final Resume R2 = new Resume(UUID_2);
  protected static final Resume R3 = new Resume(UUID_3);
  protected static final Resume R4 = new Resume("unknownUUID");
  protected static int INITIAL_ARRAY_SIZE = 3;
  protected Storage storage;

  AbstractStorageTest(Storage storage) {
    this.storage = storage;
  }

  @BeforeEach
  public void setUp() {
    storage.clear();
    storage.save(R3);
    storage.save(R1);
    storage.save(R2);
  }

  @Test
  public void size() {
    Assertions.assertEquals(INITIAL_ARRAY_SIZE, storage.size());
  }

  @Test
  public void clear() {
    storage.clear();
    assertSize(0);
  }

  @Test
  public void saveExist() {
    Assertions.assertThrows(ExistStorageException.class, () -> storage.save(R2));
  }

  @Test
  public void update() {
    storage.update(R2);
    assertSize(INITIAL_ARRAY_SIZE);
    assertGet(R2);
  }

  @Test
  public void updateNorExist() {
    Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(R4));
    assertSize(INITIAL_ARRAY_SIZE);
  }

  @Test
  public void delete() {
    storage.delete(R2.getUuid());
    assertSize(INITIAL_ARRAY_SIZE - 1);
    Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(R2.getUuid()));
  }

  @Test
  public void deleteNotExist() {
    Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(R4.getUuid()));
    assertSize(INITIAL_ARRAY_SIZE);
  }

  @Test
  public void get() {
    assertGet(R1);
    assertGet(R2);
    assertGet(R3);
  }

  @Test
  public void getNotExist() {
    Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(R4.getUuid()));
  }

  @Test
  public void saveOverflow() {
    Assertions.assertThrows(
        StorageException.class,
        () -> {
          for (int i = INITIAL_ARRAY_SIZE; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("uuid" + i));
          }
        });
  }

  protected void assertGet(Resume r) {
    Assertions.assertEquals(r, storage.get(r.getUuid()));
  }

  protected void assertSize(int size) {
    Assertions.assertEquals(size, storage.size());
  }
}
