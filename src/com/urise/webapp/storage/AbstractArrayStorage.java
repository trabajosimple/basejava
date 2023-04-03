package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
  public static final int STORAGE_LIMIT = 10000;
  protected final Resume[] storage = new Resume[STORAGE_LIMIT];
  private int size;

  @Override
  protected final void addElement(Object index, Resume resume) {
    if (size == STORAGE_LIMIT) {
      throw new StorageException("Storage overflow", resume.getUuid());
    }
    addArrayElement((Integer) index, resume);
    size++;
  }

  @Override
  protected final void updateElement(Object index, Resume resume) {
    storage[(Integer) index] = resume;
  }

  @Override
  protected final Resume getElement(Object index) {
    return new Resume(storage[(Integer) index]);
  }

  @Override
  protected final void deleteElement(Object index) {
    deleteArrayElement((Integer) index);
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
  protected boolean isExist(Object index) {
    return (Integer) index >= 0;
  }

  protected abstract void addArrayElement(int index, Resume resume);

  protected abstract void deleteArrayElement(int index);
}
