package com.bing.lan;

import com.bing.lan.domain.Car;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#_validating_constraints
 * Created by oopcoder at 2022/7/28 22:34 .
 */
public class CarTest {

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
  public void manufacturerIsNull() {
    Car car = new Car(null, "DD-AB-123", 4);

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(1, constraintViolations.size());
    assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void licensePlateTooShort() {
    Car car = new Car("Morris", "D", 4);

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(1, constraintViolations.size());
    assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void seatCountTooLow() {
    Car car = new Car("Morris", "DD-AB-123", 1);

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(1, constraintViolations.size());
    assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
  }

  @Test
  public void carIsValid() {
    Car car = new Car("Morris", "DD-AB-123", 2);

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(0, constraintViolations.size());
  }

  @Test
  public void carIsAllValidFailed() {
    Car car = new Car(null, "D", 1);

    Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

    assertEquals(3, constraintViolations.size());
  }
}