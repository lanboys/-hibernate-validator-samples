package com.bing.lan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lanbing at 2022/7/29 9:23
 */

@Slf4j
@RestController
public class HelloworldController {

  @RequestMapping("/hello")
  public String hello() {
    return "hello hibernate validator";
  }
}
