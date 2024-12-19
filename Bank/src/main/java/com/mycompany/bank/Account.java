package com.mycompany.bank;

public class Account {

    private int number;
    private int balance;
    private Person holder;

    // Constructor para inicializar la cuenta
    public Account(int number, int balance, Person holder) {
        this.number = number;
        this.balance = balance;
        this.holder = holder;
    }

    // Métodos getter
    public int getNumber() {

        return this.number;
    }

    public int getBalance() {

        return this.balance;
    }

    public Person getHolder() {

        return this.holder;
    }

    // Métodos setter para modificar balance y titular
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setHolder(Person holder) {
        this.holder = holder;
    }
}
