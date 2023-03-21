package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/** Array based storage for Resumes */
public class ArrayStorage extends AbstractArrayStorage {

  @Override
  protected int getIndex(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected void addElement(int index, Resume r) {
    storage[size++] = new Resume(r);
  }

  @Override
  protected void deleteElement(int i) {
    storage[i] = storage[--size];
    storage[size] = null;
  }
}
