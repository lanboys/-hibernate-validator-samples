package com.bing.lan.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by oopcoder at 2022/7/28 23:21 .
 */
@Data
public class CarContainer {

  // 注释该行进行测试
  @Valid
  List<Car> cars = new ArrayList<>();

  @NotNull
  private String name;

  public CarContainer() {
  }

  public CarContainer(String name) {
    this.name = name;
  }

  public void addPart(Car part) {
    cars.add(part);
  }
}
