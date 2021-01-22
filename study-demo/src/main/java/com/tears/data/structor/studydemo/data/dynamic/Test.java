package com.tears.data.structor.studydemo.data.dynamic;

public class Test {

  public static void main(String[] args) {
    DynamicArrayList list = new DynamicArrayList();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    for (int i = 0; i < 20; i++) {
      list.add(i + 5);
    }
    System.out.println(list.remove(2));
    list.add(list.size(), 5);
    list.set(0, 50);
    System.out.println(list.toString());
    System.out.println(list.capacity());
  }
}
