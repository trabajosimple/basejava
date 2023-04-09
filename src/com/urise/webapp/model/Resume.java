package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

/** Initial resume class */
public class Resume implements Comparable<Resume> {
  private final String uuid;
  private final String fullName;

  public Resume(String fullName) {
    this(UUID.randomUUID().toString(), fullName);
  }

  public Resume(String uuid, String fullName) {
    Objects.requireNonNull(uuid, "uuid must not be null");
    Objects.requireNonNull(fullName, "fullName must not be null");
    this.uuid = uuid;
    this.fullName = fullName;
  }

  public Resume(Resume r) {
    this.uuid = r.uuid;
    this.fullName = r.fullName;
  }

  public String getUuid() {
    return uuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Resume resume = (Resume) o;

    if (!uuid.equals(resume.uuid)) return false;
    return fullName.equals(resume.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid);
  }

  @Override
  public String toString() {
    return uuid;
  }

  @Override
  public int compareTo(Resume o) {
    return uuid.compareTo(o.uuid);
  }
}
