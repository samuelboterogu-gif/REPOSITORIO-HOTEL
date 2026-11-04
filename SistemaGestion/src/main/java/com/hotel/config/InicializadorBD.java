package com.hotel.config;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InicializadorBD {

    public static void inicializarBaseDeDatos() {
       
        String sqlCliente = "CREATE TABLE IF NOT EXISTS cliente (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) UNIQUE NOT NULL, " +
                "telefono VARCHAR(20)" +
                ");";

        String sqlHabitacion = "CREATE TABLE IF NOT EXISTS habitacion (" +
                "numero INT PRIMARY KEY, " +
                "tipo VARCHAR(50) NOT NULL, " +
                "precio DECIMAL(10,2) NOT NULL, " +
                "disponible BOOLEAN DEFAULT TRUE" +
                ");";

        String sqlReserva = "CREATE TABLE IF NOT EXISTS reserva (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "cliente_id INT, " +
                "habitacion_numero INT, " +
                "fecha_inicio DATE, " +
                "fecha_fin DATE, " +
                "FOREIGN KEY (cliente_id) REFERENCES cliente(id), " +
                "FOREIGN KEY (habitacion_numero) REFERENCES habitacion(numero)" +
                ");";

        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sqlCliente);
            stmt.execute(sqlHabitacion);
            stmt.execute(sqlReserva);
            
            System.out.println("¡Base de datos H2 inicializada y tablas creadas con éxito!");

        } catch (SQLException e) {
            System.err.println("Error al inicializar las tablas en la base de datos: " + e.getMessage());
        }
    }
}