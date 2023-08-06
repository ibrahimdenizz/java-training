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
}