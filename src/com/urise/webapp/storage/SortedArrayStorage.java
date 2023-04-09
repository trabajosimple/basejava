package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

  @Override
  protected Integer getSearchKey(String uuid) {
    return Arrays.binarySearch(storage, 0, size(), new Resume(uuid));
  }

  @Override
  protected void addArrayElement(int searchKey, Resume resume) {
    int index = -searchKey - 1;
    System.arraycopy(storage, index, storage, index + 1, size() - index);
    storage[index] = resume;
  }

  @Override
  protected void deleteArrayElement(int searchKey) {
    System.arraycopy(storage, searchKey + 1, storage, searchKey, size() - searchKey);
  }
}
