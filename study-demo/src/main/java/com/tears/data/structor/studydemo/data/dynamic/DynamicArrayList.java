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

  public void add(int element) {
    //elements[size++] = element;
    add(size, element);
  }

  public int get(int index) {
    rangeCheck(index);
    return elements[index];
  }

  public int set(int index, int element) {
    rangeCheck(index);
    int old = elements[index];
    elements[index] = element;
    return old;
  }

  public void add(int index, int element) {
    rangeCheckForAdd(index);
    for (int i = size - 1; i >= index; i--) {
      elements[i + 1] = elements[i];
    }
    elements[index] = element;
    size++;
  }

  public int remove(int index) {
    rangeCheck(index);
    int old = elements[index];
    for (int i = index; i < size - 1; i++) {
      elements[i] = elements[i + 1];
    }
    size--;
    return old;
  }

  public int indexOf(int element) {
    for (int index = 0; index < elements.length; index++) {
      if (elements[index] == element) {
        return index;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder();
    sb.append("size = ").append(size).append(" , elements = [");
    for (int index = 0; index < size; index++) {
      sb.append(elements[index]).append(", ");
    }
    if (size > 0) {
      int index = sb.lastIndexOf(",");
      sb.delete(index, index + 2);
    }
    sb.append("]");
    return sb.toString();
  }

  private void rangeCheckForAdd(int index) {
    if (index < 0 || index > size) {
      outOFBounds(index);
    }
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      outOFBounds(index);
    }
  }

  private void outOFBounds(int index) {
    throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
  }
}
