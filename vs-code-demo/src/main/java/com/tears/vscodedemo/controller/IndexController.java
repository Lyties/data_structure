package com.tears.vscodedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhangxing
 */
@Controller
public class IndexController {

  @GetMapping(value = { "", "/", "/index" })
  public String index() {
    return "redirect:/index.html";
  }

  @GetMapping(value = { "index.html" })
  public String html() {
    return "index";
  }
}
