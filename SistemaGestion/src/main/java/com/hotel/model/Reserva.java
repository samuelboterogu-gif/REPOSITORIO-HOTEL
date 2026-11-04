package com.hotel.model;

import java.util.Date;

/**
 * Clase que representa una reserva realizada dentro del hotel.
 */
public class Reserva {
    private int idReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private String estadoReserva;
    private double costoTotal;

    /**
     * Constructor de la reserva.
     * 
     * @param idReserva Identificador de la reserva
     * @param fechaInicio Fecha de check-in programada
     * @param fechaFin Fecha de check-out programada
     * @param estadoReserva Estado (Pendiente, Confirmada, Cancelada, Finalizada)
     * @param costoTotal Importe asignado inicialmente
     */
    public Reserva(int idReserva, Date fechaInicio, Date fechaFin, String estadoReserva, double costoTotal) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = estadoReserva;
        this.costoTotal = costoTotal;
    }

    /**
     * Calcula el monto total segun el tiempo de estadia.
     * 
     * @return El costo acumulado calculado
     */
    public double calcularCostoTotal() {
        long diferenciaMs = fechaFin.getTime() - fechaInicio.getTime();
        long dias = diferenciaMs / (1000 * 60 * 60 * 24);
        if (dias <= 0) dias = 1;
        this.costoTotal = dias * 100.0; // Tarifa base referencial
        return this.costoTotal;
    }

    /**
     * Modifica el estado de la reserva a "Confirmada".
     */
    public void confirmarReserva() {
        this.estadoReserva = "Confirmada";
    }

    /**
     * Modifica el estado de la reserva a "Cancelada".
     */
    public void cancelarReserva() {
        this.estadoReserva = "Cancelada";
    }

    public int getIdReserva() { return idReserva; }
    public String getEstadoReserva() { return estadoReserva; }
    public double getCostoTotal() { return costoTotal; }
}