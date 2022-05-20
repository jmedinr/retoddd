package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.events.VendedorAsignado;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class VendedorAsignadoUseCaseTest {

    @Test
    void asignarVendedor() {

        var vendedorId = VendedorId.of("741");
        var nombre = new Nombre("Susana");
        var telefono = new Telefono("2224556895");
        var correo = new Correo("susana@ventas.com");
        Set<Cliente> clienteSet = new HashSet<>();
        var clienteId = ClienteId.of("875");
        var documento = new Documento("78459524");
        var nombreCliente = new Nombre("Pepito");
        var telefonoCliente = new Telefono("7845879856");
        var correoCliente = new Correo("pepito@cliente.com");
        var cliente = new Cliente(clienteId, documento, nombreCliente, telefonoCliente, correoCliente);
        clienteSet.add(cliente);
        Set<Auto> listaAutoSet = new HashSet<>();
        var autoId = AutoId.of("88");
        var marca = new Marca("Chevrolet");
        var placa = new Placa("XYZ785");
        var auto = new Auto(autoId, marca, placa);
        listaAutoSet.add(auto);
        Set<ListaRepuestos> listaRepuestosSet = new HashSet<>();
        var repuesto1 = new ListaRepuestos("Palanquilla de luces nuevo");
        var repuesto2 = new ListaRepuestos("motor v8 nuevo");
        listaRepuestosSet.add(repuesto1);
        listaRepuestosSet.add(repuesto2);

        var event = new VendedorAsignado(vendedorId, nombre, telefono, correo, clienteSet,
                listaAutoSet, listaRepuestosSet);

        var useCase = new VendedorAsignadoUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var rondaCreada = (VendedorAsignado) events.get(0);
        Assertions.assertEquals("Susana", rondaCreada.getNombre().value());
    }
}