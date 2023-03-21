package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

/** Test for your ArrayStorage implementation */
public class MainTestArrayStorage {
  static final Storage ARRAY_STORAGE = new ArrayStorage();
  static final Storage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

  public static void main(String[] args) {
    System.out.println("The result of verification of array storage");
    checkArray(ARRAY_STORAGE);
    System.out.println("\nThe result of verification of sorted array storage");
    checkArray(SORTED_ARRAY_STORAGE);
  }

  static void checkArray(Storage storage) {
    Resume r1 = new Resume("uuid4");
    Resume r2 = new Resume("uuid2");
    Resume r3 = new Resume("uuid1");

    storage.save(r1);
    storage.save(r2);
    storage.save(r3);

    System.out.println("Get r1: " + storage.get(r1.getUuid()));
    System.out.println("Size: " + storage.size());
    System.out.println("Get dummy: " + storage.get("dummy"));
    storage.delete(r1.getUuid());
    printAll(storage);
    storage.update(r1);
    printAll(storage);
    storage.update(r2);
    printAll(storage);
    storage.clear();
    printAll(storage);
    System.out.println("Size: " + storage.size());
  }

  static void printAll(Storage storage) {
    System.out.println("\nGet All");
    for (Resume r : storage.getAll()) {
      System.out.println(r);
    }
  }
}
