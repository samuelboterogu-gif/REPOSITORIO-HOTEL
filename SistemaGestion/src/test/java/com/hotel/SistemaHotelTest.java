package com.hotel;

import com.hotel.model.Cliente;
import com.hotel.model.Habitacion;
import com.hotel.model.Recepcionista;
import com.hotel.model.Reserva;
import com.hotel.model.Pago;
import com.hotel.model.Factura;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaHotelTest {

    private Cliente cliente;
    private Habitacion habitacion;
    private Recepcionista recepcionista;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente(1, "samuel Pérez", "123456789", "samuel@email.com", "3001234567");
        habitacion = new Habitacion(101, "Suite", 150.0, "Disponible");
        recepcionista = new Recepcionista(2, "isabella marin", "987654321", "isa@hotel.com", "3007654321", "EMP-001", "Mañana");
    }

    @Test
    public void testSolicitarYCancelarReservaCliente() {
        Date inicio = new Date();
        Date fin = new Date(inicio.getTime() + (1000 * 60 * 60 * 24 * 2)); 

        Reserva reserva = cliente.solicitarReserva(inicio, fin, habitacion);
        assertNotNull(reserva);
        assertEquals("Pendiente", reserva.getEstadoReserva());

        boolean cancelada = cliente.cancelarReserva(reserva);
        assertTrue(cancelada);
        assertEquals("Cancelada", reserva.getEstadoReserva());
    }

    @Test
    public void testVerificarDisponibilidadHabitacion() {
        assertTrue(habitacion.esDisponible(new Date(), new Date()));
        
        habitacion.cambiarEstado("Ocupada");
        assertFalse(habitacion.esDisponible(new Date(), new Date()));
    }

    @Test
    public void testCheckInYCheckOutRecepcionista() {
        Date inicio = new Date();
        Date fin = new Date(inicio.getTime() + (1000 * 60 * 60 * 24 * 3));

        Reserva reserva = cliente.solicitarReserva(inicio, fin, habitacion);
        
        recepcionista.registrarCheckIn(reserva);
        assertEquals("Confirmada", reserva.getEstadoReserva());

        Factura factura = recepcionista.registrarCheckOut(reserva);
        assertNotNull(factura);
        assertTrue(factura.getTotalPagar() > 0);
    }

    @Test
    public void testProcesarPagoExitoso() {
        Pago pago = new Pago(1, 300.0, new Date(), "Tarjeta");
        assertTrue(pago.procesarPago());
    }
}