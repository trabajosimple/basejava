package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
  private final List<Resume> storage = new ArrayList<>();

  @Override
  protected Integer getindex(String uuid) {
    for (int i = 0; i < storage.size(); i++) {
      if (storage.get(i).getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  protected void addElement(Object index, Resume r) {
    storage.add(r);
  }

  @Override
  protected void updateElement(Object index, Resume r) {
    storage.set((Integer) index, r);
  }

  @Override
  protected Resume getElement(Object index) {
    return storage.get((Integer) index);
  }

  @Override
  protected void deleteElement(Object index) {
    storage.remove((int) index);
  }

  @Override
  protected boolean isExist(Object index) {
    return (Integer) index >= 0;
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public Resume[] getAll() {
    return storage.toArray(new Resume[0]);
  }

  @Override
  public int size() {
    return storage.size();
  }
}
