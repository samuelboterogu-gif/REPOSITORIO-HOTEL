package com.hotel.model.dao;

import com.hotel.config.ConexionDB;
import com.hotel.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    
    public void insertarCliente(Cliente cliente, String email, String telefono) {
        String sql = "INSERT INTO cliente (nombre, email, telefono) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, email);
            pstmt.setString(3, telefono);

            
            pstmt.executeUpdate();
            System.out.println("¡Cliente guardado exitosamente en la base de datos H2!");

        } catch (SQLException e) {
            System.err.println("Error al guardar el cliente en la base de datos: " + e.getMessage());
        }
    }
}