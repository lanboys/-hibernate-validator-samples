package com.bing.lan.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Created by oopcoder at 2022/7/28 22:33 .
 */
@Data
public class Car {

  @NotNull
  private String manufacturer;

  @NotNull
  @Size(min = 2, max = 14)
  private String licensePlate;

  @Min(2)
  private int seatCount;

  public Car(String manufacturer, String licencePlate, int seatCount) {
    this.manufacturer = manufacturer;
    this.licensePlate = licencePlate;
    this.seatCount = seatCount;
  }

  //getters and setters ...
}
