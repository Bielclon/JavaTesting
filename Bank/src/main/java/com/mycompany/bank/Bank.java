/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bank {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        // Mensaje de bienvenida
        System.out.println("Bienvenido al banco!");

        // Crear un ArrayList para almacenar cuentas
        ArrayList<Account> accounts = new ArrayList<Account>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Introduce el numero de la cuenta " + i + ": ");
            int number = sc.nextInt();
            System.out.println("Introduce el balance de la cuenta " + i + ": ");
            int balance = sc.nextInt();

            sc.nextLine(); // Limpiar el salto de línea pendiente

            System.out.println("Introduce el nombre del usuario de la cuenta " + i + ": ");
            String name = sc.nextLine();
            System.out.println("Introduce el apellido del usuario de la cuenta " + i + ": ");
            String surname = sc.nextLine();
            System.out.println("Introduce la edad del usuario de la cuenta " + i + ": ");
            int age = sc.nextInt();

            sc.nextLine(); // Limpiar buffer

            Person holder = new Person(name, surname, age);
            Account newAccount = new Account(number, balance, holder);

            accounts.add(newAccount);
        }

        System.out.println("");
        int opc = 0;
        do {
            System.out.println("------ Menu Principal ------");
            System.out.println("|1. Consultar saldo        |");
            System.out.println("|2. Ingresar dinero        |");
            System.out.println("|3. Sacar dinero           |");
            System.out.println("|4. Realizar transferencia |");
            System.out.println("|5. Consultar Datos        |");
            System.out.println("|6. Salir                  |");
            System.out.println("|Ingrese una opcion:       |");
            System.out.println("----------------------------");
            opc = sc.nextInt();
            switch (opc) {

                case 1:
                    consultarSaldo(accounts, sc);
                    break;
                case 2:
                    ingresarDinero(accounts, sc);
                    break;
                case 3:
                    sacarDinero(accounts, sc);
                    break;
                case 4:
                    transferirDinero(accounts, sc);
                    break;
                case 5:
                    consultarDatos(accounts, sc);
                    break;
                case 6:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opc != 6);
    }

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
