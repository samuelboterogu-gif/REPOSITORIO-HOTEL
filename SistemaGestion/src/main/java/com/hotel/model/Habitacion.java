package com.hotel.model;

import java.util.Date;

/**
 * Clase que representa una habitacion fisica dentro del catalogo del hotel.
 */
public class Habitacion {
    private int numeroHabitacion;
    private String tipo;
    private double precioPorNoche;
    private String estado;

    /**
     * Constructor de la habitacion.
     * 
     * @param numeroHabitacion Número correlativo de la habitacion
     * @param tipo Tipo de habitacion (Sencilla, Doble, Suite)
     * @param precioPorNoche Costo por cada noche de hospedaje
     * @param estado Estado actual (Disponible, Ocupada, Mantenimiento)
     */
    public Habitacion(int numeroHabitacion, String tipo, double precioPorNoche, String estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.estado = estado;
    }

    /**
     * Cambia el estado actual de la habitacion.
     * 
     * @param nuevoEstado Nuevo estado a asignar
     */
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Evalua la disponibilidad de la habitacion para un rango determinado de fechas.
     * 
     * @param fechaInicio Fecha inicial de consulta
     * @param fechaFin Fecha final de consulta
     * @return true si se encuentra en estado Disponible
     */
    public boolean esDisponible(Date fechaInicio, Date fechaFin) {
        return "Disponible".equalsIgnoreCase(this.estado);
    }

    public int getNumeroHabitacion() { return numeroHabitacion; }
    public String getTipo() { return tipo; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public String getEstado() { return estado; }
}