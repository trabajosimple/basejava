package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
  public static final int STORAGE_LIMIT = 10000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  private int size;

  @Override
  protected final void doSave(Integer searchKey, Resume resume) {
    if (size == STORAGE_LIMIT) {
      throw new StorageException("Storage overflow", resume.getUuid());
    }
    addArrayElement(searchKey, resume);
    size++;
  }

  @Override
  protected final void doUpdate(Integer searchKey, Resume resume) {
    storage[searchKey] = resume;
  }

  @Override
  protected final Resume doGet(Integer searchKey) {
    return new Resume(storage[searchKey]);
  }

  @Override
  protected final void doDelete(Integer searchKey) {
    deleteArrayElement( searchKey);
    size--;
  }

  @Override
  public final void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  @Override
  public final List<Resume> doCopyAll() {
    return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
  }

  @Override
  public final int size() {
    return size;
  }

  @Override
  protected boolean isExist(Integer searchKey) {
    return searchKey >= 0;
  }

  protected abstract void addArrayElement(int searchKey, Resume resume);

  protected abstract void deleteArrayElement(int searchKey);
}
