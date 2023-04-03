package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
  @Override
  public final void save(Resume resume) {
    addElement(getIfNotExist(resume.getUuid()), resume);
  }

  @Override
  public final void update(Resume resume) {
    updateElement(getIfExist(resume.getUuid()), resume);
  }

  @Override
  public final Resume get(String uuid) {
    return getElement(getIfExist(uuid));
  }

  @Override
  public final void delete(String uuid) {
    deleteElement(getIfExist(uuid));
  }

  protected abstract Object getindex(String uuid);

  protected abstract void addElement(Object index, Resume resume);

  protected abstract void updateElement(Object index, Resume resume);

  protected abstract Resume getElement(Object index);

  protected abstract void deleteElement(Object index);

  protected abstract boolean isExist(Object index);

  private Object getIfExist(String uuid) {
    Object index = getindex(uuid);
    if (!isExist(index)) {
      throw new NotExistStorageException(uuid);
    }
    return index;
  }

  private Object getIfNotExist(String uuid) {
    Object index = getindex(uuid);
    if (isExist(index)) {
      throw new ExistStorageException(uuid);
    }
    return index;
  }
}
