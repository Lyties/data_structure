package com.tears.data.structor.studydemo.data.dynamic;

/**
 * 动态数组
 */
public class DynamicArrayList {

  private int size;

  private int[] elements;

  private static final int DEFAULT_CAPACITY = 10;
  private static final int ELEMENT_NOT_FOUND = -1;

  public DynamicArrayList(int capacity) {
    elements = new int[Math.max(capacity, DEFAULT_CAPACITY)];
  }

  public DynamicArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public int size() {
    return size;
  }

  public void clear() {
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean contains(int element) {
    return indexOf(element) != ELEMENT_NOT_FOUND;
  }

  public void add(int element) {}

  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
    return elements[index];
  }

  public int set(int index, int element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
    int old = elements[index];
    elements[index] = element;
    return old;
  }

  public void add(int index, int element) {}

  public int remve(int index) {
    return 0;
  }

  public int indexOf(int element) {
    for (int index = 0; index < elements.length; index++) {
      if (elements[index] == element) {
        return index;
      }
    }
    return ELEMENT_NOT_FOUND;
  }
}
