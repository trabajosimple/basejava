package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
  public static final int STORAGE_LIMIT = 10000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  private int size;

  @Override
  protected final void doSave(Object searchKey, Resume resume) {
    if (size == STORAGE_LIMIT) {
      throw new StorageException("Storage overflow", resume.getUuid());
    }
    addArrayElement((Integer) searchKey, resume);
    size++;
  }

  @Override
  protected final void doUpdate(Object searchKey, Resume resume) {
    storage[(Integer) searchKey] = resume;
  }

  @Override
  protected final Resume doGet(Object searchKey) {
    return new Resume(storage[(Integer) searchKey]);
  }

  @Override
  protected final void doDelete(Object searchKey) {
    deleteArrayElement((Integer) searchKey);
    size--;
  }

  public final void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  public final Resume[] getAll() {
    return Arrays.copyOfRange(storage, 0, size);
  }

  public final int size() {
    return size;
  }

  @Override
  protected boolean isExist(Object searchKey) {
    return (Integer) searchKey >= 0;
  }

  protected abstract void addArrayElement(int searchKey, Resume resume);

  protected abstract void deleteArrayElement(int searchKey);
}
