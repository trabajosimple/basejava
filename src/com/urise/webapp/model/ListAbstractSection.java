package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListAbstractSection extends AbstractSection {
    private final List<String> items;

    public ListAbstractSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListAbstractSection that = (ListAbstractSection) o;
    return Objects.equals(items, that.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override public String toString() {
    return "ListSection{" +
    "items=" + items +
    '}';
}}
