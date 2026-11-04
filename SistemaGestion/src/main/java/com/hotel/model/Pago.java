package com.hotel.model;

import java.util.Date;

public class Pago {
    private int idPago;
    private double monto;
    private Date fechaPago;
    private String metodoPago;

    public Pago(int idPago, double monto, Date fechaPago, String metodoPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    public boolean procesarPago() {
        return this.monto > 0;
    }

    public int getIdPago() { return idPago; }
    public double getMonto() { return monto; }
    public Date getFechaPago() { return fechaPago; }         // Agregado
    public String getMetodoPago() { return metodoPago; }     // Agregado
}