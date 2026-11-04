package com.hotel.model;

/**
 * Clase que representa al personal de recepcion encargado de atender las estancias.
 * Extiende de {@link Usuario}.
 */
public class Recepcionista extends Usuario {
    private String codigoEmpleado;
    private String turno;

    /**
     * Constructor para la clase Recepcionista.
     * 
     * @param idUsuario Identificador del usuario
     * @param nombre Nombre completo
     * @param documento Documento de identidad
     * @param correo Correo electronico
     * @param telefono Telefono de contacto
     * @param codigoEmpleado Codigo asignado de empleado
     * @param turno Turno de trabajo (Mañana, Tarde, Noche)
     */
    public Recepcionista(int idUsuario, String nombre, String documento, String correo, String telefono, String codigoEmpleado, String turno) {
        super(idUsuario, nombre, documento, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    /**
     * Registra el Check-In del cliente cambiando el estado de la reserva.
     * 
     * @param reserva Reserva sobre la cual registrar la llegada
     */
    public void registrarCheckIn(Reserva reserva) {
        reserva.confirmarReserva();
    }

    /**
     * Registra el Check-Out del cliente y genera la liquidacion o factura.
     * 
     * @param reserva Reserva sobre la cual finalizar la estancia
     * @return Objeto Factura con el total a pagar
     */
    public Factura registrarCheckOut(Reserva reserva) {
        double costoTotal = reserva.calcularCostoTotal();
        return new Factura(1, costoTotal, new java.util.Date());
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public String getTurno() { return turno; }
}