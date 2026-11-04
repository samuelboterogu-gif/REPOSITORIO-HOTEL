package com.hotel.model;

import java.util.Date;

public class Factura {
    private int idFactura;
    private double totalPagar;
    private Date fechaEmision;

    public Factura(int idFactura, double totalPagar, Date fechaEmision) {
        this.idFactura = idFactura;
        this.totalPagar = totalPagar;
        this.fechaEmision = fechaEmision;
    }

    public int getIdFactura() { return idFactura; }
    public double getTotalPagar() { return totalPagar; }
    public Date getFechaEmision() { return fechaEmision; } // Agregado para usar el atributo
}