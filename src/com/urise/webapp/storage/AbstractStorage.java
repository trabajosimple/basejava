package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
  private final static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
  @Override
  public final void save(Resume resume) {
    LOG.info("save " + resume);
    doSave(getNotExistingSearchKey(resume.getUuid()), resume);
  }

  @Override
  public final void update(Resume resume) {
    LOG.info("update " + resume);
    doUpdate(getExistingSearchKey(resume.getUuid()), resume);
  }

  @Override
  public final Resume get(String uuid) {
    LOG.info("get a resume with uuid " + uuid);
    return doGet(getExistingSearchKey(uuid));
  }

  @Override
  public final List<Resume> getAllSorted() {
    List<Resume> list = doCopyAll();
    Collections.sort(list);
    return list;
  }

  @Override
  public final void delete(String uuid) {
    LOG.info("delete a resume with uuid " + uuid);
    doDelete(getExistingSearchKey(uuid));
  }

  private SK getExistingSearchKey(String uuid) {
    SK key = getSearchKey(uuid);
    if (!isExist(key)) {
      throw new NotExistStorageException(uuid);
    }
    return key;
  }

  private SK getNotExistingSearchKey(String uuid) {
    SK key = getSearchKey(uuid);
    if (isExist(key)) {
      throw new ExistStorageException(uuid);
    }
    return key;
  }

  protected abstract SK getSearchKey(String uuid);

  protected abstract void doSave(SK searchKey, Resume resume);

  protected abstract void doUpdate(SK searchKey, Resume resume);

  protected abstract Resume doGet(SK searchKey);

  protected abstract List<Resume> doCopyAll();

  protected abstract void doDelete(SK searchKey);

  protected abstract boolean isExist(SK searchKey);
}
