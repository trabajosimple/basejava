package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

  @Override
  protected int getIndex(String uuid) {
    return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
  }

  @Override
  protected void addElement(int index, Resume r) {
    int i = -index - 1;
    System.arraycopy(storage, i, storage, i + 1, size - i);
    storage[i] = r;
    size++;
  }

  @Override
  protected void deleteElement(int i) {
    System.arraycopy(storage, i+1, storage, i, size - i);
    size--;
  }
}
