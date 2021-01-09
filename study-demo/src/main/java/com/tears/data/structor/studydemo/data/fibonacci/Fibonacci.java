package com.tears.data.structor.studydemo.data.fibonacci;

import com.tears.data.structor.studydemo.utils.TimeTools;
import jdk.javadoc.internal.tool.Main;

/**
 * 斐波那契数列
 * 0 1 2 3 4 5 6 7
 * 0 1 1 2 3 5 8 13 21
 */
public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(fib1(40));
    System.out.println(fib2(64));

    TimeTools.cost(() -> fib1(40), "fib1");
    TimeTools.cost(() -> fib2(40), "fib2");
  }

  /**
   * 递归
   * @param n
   * @return
   */
  public static int fib1(int n) {
    if (n <= 1) {
      return n;
    }
    return fib1(n - 1) + fib1(n - 2);
  }

  public static int fib2(int n) {
    if (n <= 1) {
      return n;
    }
    int first = 0;
    int second = 1;
    int sum = 0;
    for (int i = 0; i < n - 1; i++) {
      sum = first + second;
      first = second;
      second = sum;
    }
    return sum;
  }
}
