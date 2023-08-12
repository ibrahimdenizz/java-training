package com.ibrahimdenizz.javacourse.lesson2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void shouldReturnHelloWorld() {
        Person ibrahim = new Person();
        assertEquals("Hello World", ibrahim.helloWorld());
    }

    @Test
    public void shouldReturnHelloIbrahim() {
        Person person = new Person();
        assertEquals("Hello Ibrahim", person.hello("Ibrahim"));
    }

    @Test
    public void shouldReturnNumberOfPersons() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();

        assertEquals(4, Person.numberOfPersons());
    }

    @Test
    public void demostrateBoolean() {
        boolean monday = false;
        boolean raining = true;
        boolean tuesday = true;
        boolean sunny = true;

        if ((monday && raining) || (tuesday && sunny)) {
            drinkBeer();
        }else {
            
        }
    }
}