package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  protected Object getindex(String uuid) {
    return storage.get(uuid) == null ? null : uuid;
  }

  @Override
  protected void addElement(Object index, Resume resume) {
    storage.put(resume.getUuid(), resume);
  }

  @Override
  protected void updateElement(Object index, Resume resume) {
    addElement(resume.getUuid(), resume);
  }

  @Override
  protected Resume getElement(Object index) {
    return storage.get((String) index);
  }

  @Override
  protected void deleteElement(Object index) {
    storage.remove(index);
  }

  @Override
  protected boolean isExist(Object index) {
    return index!=null;
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
