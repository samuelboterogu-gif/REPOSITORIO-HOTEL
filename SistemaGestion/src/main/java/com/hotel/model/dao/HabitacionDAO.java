package com.hotel.model.dao;

import com.hotel.config.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabitacionDAO {

    
    public void insertarHabitacion(int numero, String tipo, double precio, boolean disponible) {
        String sql = "INSERT INTO habitacion (numero, tipo, precio, disponible) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numero);
            pstmt.setString(2, tipo);
            pstmt.setDouble(3, precio);
            pstmt.setBoolean(4, disponible);

            pstmt.executeUpdate();
            System.out.println("¡Habitación N° " + numero + " guardada exitosamente en la base de datos H2!");

        } catch (SQLException e) {
            System.err.println("Error al guardar la habitación en la base de datos: " + e.getMessage());
        }
    }
}