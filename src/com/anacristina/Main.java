package com.anacristina;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    AddressBook contactos = new AddressBook();
    Scanner registro = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // write your code here
        AddressBook addressBook = new AddressBook();
        Main main = new Main();
        main.main();
    }

    Scanner sn = new Scanner(System.in);
    int opciones = 0;
    boolean Exit = false;

    public void main() throws IOException {
        while (!Exit) {
            System.out.println("Selecciones una opción");
            System.out.println("1-Lista de contactos");
            System.out.println("2-Agregar contacto");
            System.out.println("3-Borrar contacto");
            System.out.println("4-Salir");
            try {
                opciones = sn.nextInt();
                switch (opciones) {
                    case 1:
                        lista();
                        break;
                    case 2:
                        agregar();
                        break;
                    case 3:
                        borrar();
                        break;
                    case 4:
                        Exit = true;
                        System.out.println("Exit");
                        break;
                    default:
                        throw new IllegalStateException("esta opcion es invalida" + opciones);
                }
            } catch (InputMismatchException e) {
                System.out.println("seleccione una opcion de la lista");
                sn.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void lista() throws IOException {
        contactos.lista();
    }

    private void agregar() throws IOException {
        System.out.println("Añadir nombre del contacto:");
        var nombre = registro.next();
        System.out.println("Añadir numero");
        var numero = registro.next();
        contactos.create(nombre, numero);
        System.out.println("Se añadio correctamente");
    }

    private void borrar() throws IOException {
        System.out.println("ingrese nombre de contacto a eliminar");
        var borrar = registro.next();
        contactos.delete(borrar);
        {
            System.out.println("Se elimino el contacto");
        }
    }
}