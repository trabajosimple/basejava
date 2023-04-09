package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  protected Resume getSearchKey(String uuid) {
    return storage.get(uuid);
  }

  @Override
  protected void doSave(Object searchKey, Resume resume) {
    storage.put(resume.getUuid(), resume);
  }

  @Override
  protected void doUpdate(Object searchKey, Resume resume) {
    doSave(resume.getUuid(), resume);
  }

  @Override
  protected Resume doGet(Object searchKey) {
    return storage.get((String) searchKey);
  }

  @Override
  protected void doDelete(Object searchKey) {
    storage.remove(searchKey);
  }

  @Override
  protected boolean isExist(Object resume) {
    return resume != null;
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public List<Resume> doCopyAll() {
    return new ArrayList(storage.values());
  }

  @Override
  public int size() {
    return storage.size();
  }
}
