package com.hotel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa a un cliente hospedado o registrado en el sistema.
 * Extiende de {@link Usuario}.
 */
public class Cliente extends Usuario {
    private List<Reserva> historialReservas;

    /**
     * Constructor para la clase Cliente.
     * 
     * @param idUsuario Identificador unico del cliente
     * @param nombre Nombre completo
     * @param documento Documento de identidad
     * @param correo Correo electronico
     * @param telefono Telefono de contacto
     */
    public Cliente(int idUsuario, String nombre, String documento, String correo, String telefono) {
        super(idUsuario, nombre, documento, correo, telefono);
        this.historialReservas = new ArrayList<>();
    }

    /**
     * Solicita la creacion de una nueva reserva.
     * 
     * @param fechaInicio Fecha de inicio de la estancia
     * @param fechaFin Fecha de finalizacion de la estancia
     * @param habitacion Habitacion solicitada
     * @return Objeto Reserva creado
     */
    public Reserva solicitarReserva(Date fechaInicio, Date fechaFin, Habitacion habitacion) {
        Reserva nuevaReserva = new Reserva(1, fechaInicio, fechaFin, "Pendiente", 0.0);
        historialReservas.add(nuevaReserva);
        return nuevaReserva;
    }

    /**
     * Cancela una reserva previamente realizada.
     * 
     * @param reserva Reserva a cancelar
     * @return true si la cancelacion fue exitosa
     */
    public boolean cancelarReserva(Reserva reserva) {
        if (historialReservas.contains(reserva)) {
            reserva.cancelarReserva();
            return true;
        }
        return false;
    }

    public List<Reserva> getHistorialReservas() {
        return historialReservas;
    }
}