package com.tears.data.structor.studydemo.utils;

import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeTools {

  private static final SimpleDateFormat fmt = new SimpleDateFormat(
    "HH:mm:ss:SSS"
  );

  public interface Task {
    void run();
  }

  public static void cost(Task task, String... title) {
    String t = title != null ? title[0] : "";
    if (task != null) {
      System.out.println(t + ":开始执行。。。");
      long start = System.currentTimeMillis();
      task.run();
      long end = System.currentTimeMillis();
      System.out.println(t + "结束执行");
      System.out.println("耗时" + (end - start) + "ms");
      System.out.println("---------------------");
      log.info("执行完成");
    }
  }
}
