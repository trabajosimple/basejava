package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

  @Override
  protected Integer getindex(String uuid) {
    return Arrays.binarySearch(storage, 0, size(), new Resume(uuid));
  }

  @Override
  protected void addArrayElement(int i, Resume resume) {
    int index = -i - 1;
    System.arraycopy(storage, index, storage, index + 1, size() - index);
    storage[index] = resume;
  }

  @Override
  protected void deleteArrayElement(int i) {
    System.arraycopy(storage, i + 1, storage, i, size() - i);
  }
}
