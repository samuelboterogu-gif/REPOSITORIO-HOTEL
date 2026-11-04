package com.hotel;

import com.hotel.config.InicializadorBD;
import com.hotel.model.dao.ClienteDAO;
import com.hotel.model.dao.HabitacionDAO;
import com.hotel.model.dao.ReservaDAO;
import com.hotel.model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Gestión de Hotel...");

        
        InicializadorBD.inicializarBaseDeDatos();

        Scanner scanner = new Scanner(System.in);
        
        
        ClienteDAO clienteDAO = new ClienteDAO();
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        ReservaDAO reservaDAO = new ReservaDAO();

        int opcion = 0;

        
        do {
            System.out.println("\n========================================");
            System.out.println("   === SISTEMA DE GESTION DE HOTEL ===");
            System.out.println("========================================");
            System.out.println("1. Registrar nuevo Cliente");
            System.out.println("2. Registrar nueva Habitación");
            System.out.println("3. Crear una Reserva");
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRAR CLIENTE ---");
                        System.out.print("Nombre completo: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Número de documento: ");
                        String documento = scanner.nextLine();
                        System.out.print("Correo electrónico: ");
                        String correo = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();

                        
                        Cliente cliente = new Cliente(0, nombre, documento, correo, telefono);
                        clienteDAO.insertarCliente(cliente, correo, telefono);
                        break;

                    case 2:
                        System.out.println("\n--- REGISTRAR HABITACIÓN ---");
                        System.out.print("Número de habitación: ");
                        int numHab = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Tipo de habitación (Ej: Simple, Doble, Suite): ");
                        String tipo = scanner.nextLine();
                        System.out.print("Precio por noche: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();

                        
                        habitacionDAO.insertarHabitacion(numHab, tipo, precio, true);
                        break;

                    case 3:
                        System.out.println("\n--- CREAR RESERVA ---");
                        System.out.print("ID del cliente registrado (ej. 1): ");
                        int clienteId = scanner.nextInt();
                        System.out.print("Número de la habitación: ");
                        int habitacionNum = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Fecha de inicio (AAAA-MM-DD): ");
                        String fechaInicio = scanner.nextLine();
                        System.out.print("Fecha de fin (AAAA-MM-DD): ");
                        String fechaFin = scanner.nextLine();

                        
                        reservaDAO.insertarReserva(clienteId, habitacionNum, fechaInicio, fechaFin);
                        break;

                    case 4:
                        System.out.println("\n¡Gracias por usar el sistema! Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); 
            }

        } while (opcion != 4);

        scanner.close();
        System.out.println("=== APLICACIÓN FINALIZADA ===");
    }
}