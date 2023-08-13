package com.ibrahimdenizz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", age=" + age + '}';
    }

    public Integer getId() {
        return id;
    }

    public Customer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Customer setAge(Integer age) {
        this.age = age;
        return this;
    }

}
