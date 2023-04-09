package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  protected Object getSearchKey(String uuid) {
    return uuid;
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
  protected boolean isExist(Object searchKey) {
    return storage.containsKey(searchKey);
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public Resume[] getAll() {
    return storage.values().toArray(new Resume[0]);
  }

  @Override
  public int size() {
    return storage.size();
  }
}
