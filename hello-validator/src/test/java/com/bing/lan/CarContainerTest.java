package com.bing.lan;

import com.bing.lan.domain.Car;
import com.bing.lan.domain.CarContainer;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import static org.junit.Assert.assertEquals;

/**
 * Created by oopcoder at 2022/7/28 23:23 .
 */

public class CarContainerTest {

  private static Validator validator;

  @BeforeClass
  public static void setUpValidator() {
    //ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    //validator = factory.getValidator();

    validator = Validation.byProvider(HibernateValidator.class).configure()
                          //.failFast(true)
                          .buildValidatorFactory().getValidator();
  }

  @Test
  public void test1() {
    // 级联校验测试、配合快速失败进行测试
    //@Valid 注释该行进行测试

    //CarContainer myCars = new CarContainer("myCar");
    CarContainer myCars = new CarContainer();

    Car car = new Car(null, "DD-AB-123", 4);
    myCars.addPart(car);

    car = new Car("Morris", "D", 4);
    myCars.addPart(car);

    car = new Car(null, "D", 1);
    myCars.addPart(car);

    Set<ConstraintViolation<CarContainer>> constraintViolations = validator.validate(myCars);

    System.out.println("test1(): ");
  }
}