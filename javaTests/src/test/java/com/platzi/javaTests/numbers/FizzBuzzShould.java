package com.platzi.javaTests.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void return_fizz_buzz_when_is_divisible_by_3_and_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String fizzBuzzResult = fizzBuzz.getReturn(15);
        assertEquals(fizzBuzzResult, "FizzBuzz");
    }

    @Test
    public void return_fizz_when_is_divisible_by_3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String fizzBuzzResult = fizzBuzz.getReturn(9);
        assertEquals(fizzBuzzResult, "Fizz");
    }

    @Test
    public void return_buzz_when_is_divisible_by_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String fizzBuzzResult = fizzBuzz.getReturn(10);
        assertEquals(fizzBuzzResult, "Buzz");
    }

    @Test
    public void return_the_number_when_it_is_not_divisible_by_3_either_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String fizzBuzzResult = fizzBuzz.getReturn(8);
        assertEquals(fizzBuzzResult, "8");
    }
}