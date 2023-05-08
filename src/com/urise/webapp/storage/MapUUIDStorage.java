package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUUIDStorage extends AbstractStorage<String> {
  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  protected String getSearchKey(String uuid) {
    return uuid;
  }

  @Override
  protected void doSave(String searchKey, Resume resume) {
    storage.put(resume.getUuid(), resume);
  }

  @Override
  protected void doUpdate(String searchKey, Resume resume) {
    doSave(resume.getUuid(), resume);
  }

  @Override
  protected Resume doGet(String searchKey) {
    return storage.get(searchKey);
  }

  @Override
  protected void doDelete(String searchKey) {
    storage.remove(searchKey);
  }

  @Override
  protected boolean isExist(String searchKey) {
    return storage.containsKey(searchKey);
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
