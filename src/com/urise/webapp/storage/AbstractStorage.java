package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
  @Override
  public final void save(Resume resume) {
    doSave(getNotExistingSearchKey(resume.getUuid()), resume);
  }

  @Override
  public final void update(Resume resume) {
    doUpdate(getExistingSearchKey(resume.getUuid()), resume);
  }

  @Override
  public final Resume get(String uuid) {
    return doGet(getExistingSearchKey(uuid));
  }

  @Override
  public final void delete(String uuid) {
    doDelete(getExistingSearchKey(uuid));
  }

  private Object getExistingSearchKey(String uuid) {
    Object key = getSearchKey(uuid);
    if (!isExist(key)) {
      throw new NotExistStorageException(uuid);
    }
    return key;
  }

  private Object getNotExistingSearchKey(String uuid) {
    Object key = getSearchKey(uuid);
    if (isExist(key)) {
      throw new ExistStorageException(uuid);
    }
    return key;
  }

  protected abstract Object getSearchKey(String uuid);

  protected abstract void doSave(Object searchKey, Resume resume);

  protected abstract void doUpdate(Object searchKey, Resume resume);

  protected abstract Resume doGet(Object searchKey);

  protected abstract void doDelete(Object searchKey);

  protected abstract boolean isExist(Object searchKey);
}
