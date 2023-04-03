package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/** Array based storage for Resumes */
public class ArrayStorage extends AbstractArrayStorage {

  @Override
  protected Integer getindex(String uuid) {
    for (int i = 0; i < size(); i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected void addArrayElement(int i, Resume resume) {
    storage[size()] = new Resume(resume);
  }

  @Override
  protected void deleteArrayElement(int i) {
    storage[i] = storage[size()];
    storage[size() - 1] = null;
  }
}
