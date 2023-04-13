package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

  private static final Comparator<Resume> RESUME_COMPARATOR =
        Comparator.comparing(Resume::getUuid);
//      (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

  @Override
  protected Integer getSearchKey(String uuid) {
    return Arrays.binarySearch(storage, 0, size(), new Resume(uuid, ""), RESUME_COMPARATOR);
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
