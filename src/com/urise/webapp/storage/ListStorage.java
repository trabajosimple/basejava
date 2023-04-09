package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
  private final List<Resume> storage = new ArrayList<>();

  @Override
  protected Integer getSearchKey(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (storage.get(i).getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected void doSave(Object searchKey, Resume r) {
    storage.add(r);
  }

  @Override
  protected void doUpdate(Object searchKey, Resume r) {
    storage.set((Integer) searchKey, r);
  }

  @Override
  protected Resume doGet(Object searchKey) {
    return storage.get((Integer) searchKey);
  }

  @Override
  protected void doDelete(Object searchKey) {
    storage.remove((int) searchKey);
  }

  @Override
  protected boolean isExist(Object searchKey) {
    return (Integer) searchKey >= 0;
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public List<Resume> doCopyAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public int size() {
    return storage.size();
  }
}
