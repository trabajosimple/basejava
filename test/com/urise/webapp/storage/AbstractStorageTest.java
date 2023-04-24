package com.urise.webapp.storage;

import static org.junit.jupiter.api.Assertions.*;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractStorageTest {
  protected static final String UUID_1 = "uuid0";
  protected static final String UUID_2 = "uuid1";
  protected static final String UUID_3 = "uuid2";
  protected static final Resume R1 = ResumeTestData.R1;
  protected static final Resume R2 = new Resume(UUID_2, "Sidorov");
  protected static final Resume R3 = new Resume(UUID_3, "Ivanov");
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
    assertSize(storage.size());
  }

  @Test
  public void clear() {
    storage.clear();
    assertSize(0);
  }

  @Test
  public void saveExist() {
    assertThrows(ExistStorageException.class, () -> storage.save(R2));
  }

  @Test
  public void update() {
    storage.update(R2);
    assertSize(INITIAL_ARRAY_SIZE);
    assertGet(R2);
  }

  @Test
  public void updateNorExist() {
    assertThrows(NotExistStorageException.class, () -> storage.update(R4));
    assertSize(INITIAL_ARRAY_SIZE);
  }

  @Test
  public void delete() {
    storage.delete(R2.getUuid());
    assertSize(INITIAL_ARRAY_SIZE - 1);
    assertThrows(NotExistStorageException.class, () -> storage.get(R2.getUuid()));
  }

  @Test
  public void deleteNotExist() {
    assertThrows(NotExistStorageException.class, () -> storage.delete(R4.getUuid()));
    assertSize(INITIAL_ARRAY_SIZE);
  }

  @Test
  public void get() {
    assertGet(R1);
    assertGet(R2);
    assertGet(R3);
  }

  @Test
  public void getAllSorted() {
    List<Resume> list = storage.getAllSorted();
    assertEquals(3, list.size());
    assertEquals(list, Arrays.asList(R3, R2, R1));
  }

  @Test
  public void getNotExist() {
    assertThrows(NotExistStorageException.class, () -> storage.get(R4.getUuid()));
  }

  protected void assertGet(Resume r) {
    Resume r1 = storage.get(r.getUuid());
    assertEquals(r, storage.get(r.getUuid()));
  }

  protected void assertSize(int size) {
    assertEquals(size, storage.size());
  }
}
