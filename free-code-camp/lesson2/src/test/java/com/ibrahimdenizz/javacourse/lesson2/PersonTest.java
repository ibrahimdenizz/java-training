package com.ibrahimdenizz.javacourse.lesson2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
    @Test
    public void shouldReturnHelloWorld() {
        Person ibrahim = new Person();
        assertEquals("Hello World", ibrahim.helloWorld());
    }
}