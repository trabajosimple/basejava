package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedArrayStorageTest extends AbstractStorageTest {
  SortedArrayStorageTest() {
    super(new SortedArrayStorage());
  }

  @Test
  public void getAll() {
    Assertions.assertTrue(Arrays.equals(storage.getAll(), new Resume[] {R1, R2, R3}));
  }

  @Test
  public void save() {
    storage.save(R4);
    assertSize(INITIAL_ARRAY_SIZE + 1);
    assertGet(R4);
    Assertions.assertTrue(Arrays.equals(storage.getAll(), new Resume[] {R4, R1, R2, R3}));
  }
}
