package com.ibrahimdenizz.javacourse.lesson2;

import com.ibrahimdenizz.javacourse.lesson3.Name;

public class Person {
    private Name personName;
    private static int personCounter;

    public Person(Name personName) {
        this.personName = personName;
    }

    public Person() {
        personCounter++;
        /*
         * empty on purpose - default constructor
         */
    }

    public String helloWorld() {
        return "Hello World";
    }

    public Name name() {
        return personName;
    }

    public String hello(String string) {
        return "Hello " + string;
    }

    public static int numberOfPersons() {
        return personCounter;
    }
}
