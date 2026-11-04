package com.hotel.model.dao;

import com.hotel.config.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    
    public void insertarReserva(int clienteId, int habitacionNumero, String fechaInicio, String fechaFin) {
        String sql = "INSERT INTO reserva (cliente_id, habitacion_numero, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clienteId);
            pstmt.setInt(2, habitacionNumero);
            pstmt.setString(3, fechaInicio); // Formato esperado en texto plano: "YYYY-MM-DD"
            pstmt.setString(4, fechaFin);

            pstmt.executeUpdate();
            System.out.println("¡Reserva registrada y guardada exitosamente en H2!");

        } catch (SQLException e) {
            System.err.println("Error al guardar la reserva en la base de datos: " + e.getMessage());
        }
    }
}
