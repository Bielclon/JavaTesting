/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

/**
 *
 * @author ADMIN
 */
public class Person {
    private String name;
    private String surname;
    private int age;
        public Person(String name, String surname, int age) {
        if (age < 18) {
        throw new IllegalArgumentException("El usuario debe ser mayor de edad.");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String getName(){

        return this.name;
    }
    public String getSurname(){

        return this.surname;
    }
    public int getAge(){

        return this.age;
    }
    // Métodos setter para modificar los atributos de Person
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAge(int age) {
        if (age < 18) {
        throw new IllegalArgumentException("El usuario debe ser mayor de edad.");
        }
        this.age = age;
    }
}
