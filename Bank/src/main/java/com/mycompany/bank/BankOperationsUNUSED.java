/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BankOperationsUNUSED {

    public static Account buscarCuenta(ArrayList<Account> accounts, String nombreTitular) {
        for (Account account : accounts) {
            if (account.getHolder().getName().equalsIgnoreCase(nombreTitular)) {
                return account;
            }
        }

        return null; // Si no se encuentra la cuenta
    }

    public static void consultarSaldo(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("Introduce el nombre del titular para consultar el saldo:");
        sc.nextLine(); // Limpiar el buffer
        String nombreTitular = sc.nextLine();

        Account cuenta = buscarCuenta(accounts, nombreTitular);

        if (cuenta != null) {
            System.out.println("El saldo de la cuenta es: " + cuenta.getBalance());
        } else {
            System.out.println("Cuenta no encontrada para el titular: " + nombreTitular);
        }
    }

    public static void ingresarDinero(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("Introduce el nombre de la cuenta a la que ingresar dinero:");
        sc.nextLine(); // Limpiar el buffer
        String nombreTitular = sc.nextLine();

        Account cuenta = buscarCuenta(accounts, nombreTitular);

        if (cuenta != null) {
            System.out.println("Ingrese la cantidad a ingresar:");
            int ingreso = sc.nextInt();
            cuenta.setBalance(ingreso + cuenta.getBalance());
        } else {
            System.out.println("Cuenta no encontrada para el titular: " + nombreTitular);
        }

    }

    public static void sacarDinero(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("Introduce el nombre de la cuenta a la que sacar dinero:");
        sc.nextLine(); // Limpiar el buffer
        String nombreTitular = sc.nextLine();

        Account cuenta = buscarCuenta(accounts, nombreTitular);

        if (cuenta != null) {
            System.out.println("Ingrese la cantidad a sacar:");
            int sacar = sc.nextInt();
            if (sacar < cuenta.getBalance()) {
                cuenta.setBalance(cuenta.getBalance() - sacar);
            } else {
                System.out.println("Saldo insuficiente para retirar");
            }
        } else {
            System.out.println("Cuenta no encontrada para el titular: " + nombreTitular);
        }

    }

    public static void transferirDinero(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("Introduce el nombre de la cuenta que depositara el dinero:");
        sc.nextLine(); // Limpiar el buffer
        String nombreTitular = sc.nextLine();

        Account cuentaOrigen = buscarCuenta(accounts, nombreTitular);

        System.out.println("Introduce el nombre de la cuenta que recibira el dinero:");

        nombreTitular = sc.nextLine();

        Account cuentaDestino = buscarCuenta(accounts, nombreTitular);

        if (cuentaOrigen != null && cuentaDestino != null) {
            System.out.println("Ingrese la cantidad a transferir:");
            int transferencia = sc.nextInt();
            if (transferencia < cuentaOrigen.getBalance()) {
                cuentaOrigen.setBalance(cuentaOrigen.getBalance() - transferencia);
                cuentaDestino.setBalance(cuentaDestino.getBalance() + transferencia);
            } else {
                System.out.println("Saldo insuficiente para transferir");
            }
        } else {
            System.out.println("Cuenta no encontrada");
        }

    }

    public static void consultarDatos(ArrayList<Account> accounts, Scanner sc) {

        System.out.println("Consultar los datos del usuario");
        sc.nextLine(); // Limpiar el buffer
        String nombreTitular = sc.nextLine();

        Account cuenta = buscarCuenta(accounts, nombreTitular);

        if (cuenta != null) {
            System.out.println("Informacion de la cuenta:");
            System.out.println("Nombre: " + cuenta.getHolder().getName());
            System.out.println("Apellido: " + cuenta.getHolder().getSurname());
            System.out.println("Edad: " + cuenta.getHolder().getAge());                                 
        } else {
            System.out.println("Cuenta no encontrada para el titular: " + nombreTitular);
        }
    }

}
