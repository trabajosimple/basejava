package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/** Array based storage for Resumes */
public class ArrayStorage {
  public final int STORAGE_LIMIT = 10000;
  private Resume[] storage = new Resume[STORAGE_LIMIT];
  private int size;

  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  public void save(Resume r) {
    if (size >= STORAGE_LIMIT) {
      System.out.println("ERROR: The maximum array size has been reached");
      return;
    }
    if (r.getUuid() != null && !r.getUuid().isBlank() && getIndex(r.getUuid()) < 0) {
      storage[size++] = new Resume(r);
    } else {
      System.out.println(
          "ERROR: Attempt to add a resume with existing or empty uuid = " + r.getUuid());
    }
  }

  public void update(Resume r) {
    int i = getIndex(r.getUuid());
    if (i > 0) {
      storage[i] = r;
    } else {
      System.out.println("ERROR: Unable to find a storage element with uuid = " + r.getUuid());
    }
  }

  public Resume get(String uuid) {
    int i = getIndex(uuid);
    if (i >= 0) {
      return new Resume(storage[i]);
    }
    System.out.println("ERROR: Unable to find a storage element with uuid = " + uuid);
    return null;
  }

  public void delete(String uuid) {
    int i = getIndex(uuid);
    if (i >= 0) {
      storage[i] = storage[--size];
      storage[size] = null;
      return;
    }
    System.out.println("ERROR: Unable to find a storage element with uuid = " + uuid);
  }

  /**
   * @return array, contains only Resumes in storage (without null)
   */
  public Resume[] getAll() {
    return Arrays.copyOfRange(storage, 0, size);
  }

  public int size() {
    return size;
  }

  private int getIndex(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }
}
