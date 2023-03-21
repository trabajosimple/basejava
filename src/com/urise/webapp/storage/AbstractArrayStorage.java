package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
  public static final int STORAGE_LIMIT = 10000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  protected int size;

  public final void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  public final void save(Resume r) {
    if (size == STORAGE_LIMIT) {
      System.out.println("ERROR: The maximum array size has been reached");
    }

    int index = getIndex(r.getUuid());
    if (index < 0) {
      addElement(index, r);
    } else {
      System.out.println(
          "ERROR: Attempt to add a resume with existing or empty uuid = " + r.getUuid());
    }
    return;
  }

  public final void update(Resume r) {
    int i = getIndex(r.getUuid());
    if (i > 0) {
      storage[i] = r;
    } else {
      System.out.println("ERROR: Unable to find a storage element with uuid = " + r.getUuid());
    }
  }

  public final Resume get(String uuid) {
    int i = getIndex(uuid);
    if (i >= 0) {
      return new Resume(storage[i]);
    }
    System.out.println("ERROR: Unable to find a storage element with uuid = " + uuid);
    return null;
  }

  public final void delete(String uuid) {
    int i = getIndex(uuid);
    if (i >= 0) {
      deleteElement(i);
      return;
    }
    System.out.println("ERROR: Unable to find a storage element with uuid = " + uuid);
  }

  /**
   * @return array, contains only Resumes in storage (without null)
   */
  public final Resume[] getAll() {
    return Arrays.copyOfRange(storage, 0, size);
  }

  public final int size() {
    return size;
  }

  protected abstract int getIndex(String uuid);

  protected abstract void addElement(int i, Resume r);

  protected abstract void deleteElement(int i);
}
