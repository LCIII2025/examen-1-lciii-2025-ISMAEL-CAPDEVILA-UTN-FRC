package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test.
        Estacionamiento estac = new Estacionamiento();

        Vehiculo auto = new Vehiculo("LAB3", "Toyota", Vehiculo.Tipo.AUTO);
        String dni = "242442";
        String nombre = "marcos";

        boolean ingreso = estac.ingresarVehiculo(dni, nombre, auto);
        assertTrue(ingreso);

        Ticket ticket = estac.retirarVehiculo("LAB3");

        assertTrue(ticket != null);

        assertTrue(ticket.getHoraSalida() != null);

        assertEquals("marcos", ticket.getCliente().getNombre());

        assertEquals("LAB3", ticket.getVehiculo().getPatente());


    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test.
        Vehiculo vehiculo = new Vehiculo("GOD500", "Chevrolet", Vehiculo.Tipo.AUTO);
        Cliente cliente = new Cliente("232323", "Mariano");
        Ticket ticket = new Ticket(cliente, vehiculo);

        ticket.setHoraSalida(ticket.getHoraEntrada().plusMinutes(95));

        double precio = ticket.calcularPrecio();

        assertEquals(200.0, precio);
    }

}