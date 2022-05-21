package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.events.*;
import co.com.sofkau.taller.vendedor.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FacturaGeneradaUseCaseTest {

    private final Nombre nombre = new Nombre("Susana");
    private final Telefono telefono = new Telefono("2224556895");
    private final Correo correo = new Correo("susana@ventas.com");
    private final Set<Cliente> clienteSet = new HashSet<>();
    private final ClienteId clienteId = ClienteId.of("875");
    private final Documento documento = new Documento("78459524");
    private final Nombre nombreCliente = new Nombre("Pepito");
    private final Telefono telefonoCliente = new Telefono("7845879856");
    private final Correo correoCliente = new Correo("pepito@cliente.com");
    private final Set<Auto> listaAutoSet = new HashSet<>();
    private final AutoId autoId = AutoId.of("88");
    private final Marca marca = new Marca("Chevrolet");
    private final Placa placa = new Placa("XYZ785");
    private final Set<ListaRepuestos> listaRepuestosSet = new HashSet<>();
    private final ValorCompra valorCompra = new ValorCompra(1200000);
    private final ValorReparacion valorReparacion = new ValorReparacion(500000);


    @Mock
    private DomainEventRepository repository;

    @Test
    void generarFactura() {
        var cliente = new Cliente(clienteId, documento, nombreCliente, telefonoCliente, correoCliente);
        clienteSet.add(cliente);

        var auto = new Auto(autoId, marca, placa);
        listaAutoSet.add(auto);

        var repuesto1 = new ListaRepuestos("Palanquilla de luces nuevo");
        var repuesto2 = new ListaRepuestos("motor v8 nuevo");
        listaRepuestosSet.add(repuesto1);
        listaRepuestosSet.add(repuesto2);

        var vendedorId = VendedorId.of("741");

        var event = createTriggeredEventWith(vendedorId);

        var useCase = new FacturaGeneradaUseCase();

        when(repository.getEventsBy(vendedorId.value())).thenReturn(eventStored(vendedorId));
        useCase.addRepository(repository);

        var events = executor(vendedorId, event, useCase);

        var factura = (FacturaGenerada) events.get(0);
        Assertions.assertEquals("Pepito", factura.getDatosCliente().value());
        var taller = factura.getDatosEmpresa().stream().iterator().next().value().nombreEmpresa();
        Assertions.assertEquals("Taller MultiMarcas", taller);
        Assertions.assertEquals(1700000, factura.getValorTotal().value());
    }

    private FacturaGenerada createTriggeredEventWith(VendedorId vendedorId) {

        var facturaId = FacturaId.of("1478885");
        var datosCliente = new DatosCliente(nombreCliente.value());
        Set<DatosEmpresa> datosEmpresa = new HashSet<>();
        datosEmpresa.add(new DatosEmpresa("Taller MultiMarcas", "Trabajamos por ti"));
        Set<DatosAuto> datosAuto = new HashSet<>();
        datosAuto.add(new DatosAuto(marca.value(), placa.value()));
        Set<ListaRepuestos> listaRepuestosSet = new HashSet<>();
        listaRepuestosSet.add(new ListaRepuestos("Palanquilla de luces nuevo"));
        listaRepuestosSet.add(new ListaRepuestos("motor v8"));
        var valorTotal = new ValorTotal(valorCompra, valorReparacion);
        var event = new FacturaGenerada(facturaId, vendedorId, datosCliente, datosEmpresa, datosAuto,
                listaRepuestosSet, valorCompra, valorReparacion, valorTotal);

        event.setAggregateRootId(vendedorId.value());
        return event;
    }

    private List<DomainEvent> eventStored(VendedorId vendedorId) {
        var tipoPago = new TipoPago(TipoPago.Pago.CONTADO);
        var metodoPago = new MetodoPago(MetodoPago.Metodo.TRANSFERENCIA);
        var salida = new Salida(LocalDateTime.now(), LocalDate.now());
        var valorTotal = new ValorTotal(valorCompra, valorReparacion);

        return List.of(
                new VendedorAsignado(vendedorId, nombre, telefono, correo, clienteSet, listaAutoSet, listaRepuestosSet),
                new CompraGenerada(vendedorId, valorCompra),
                new VentaGenerada(vendedorId, tipoPago, metodoPago, valorReparacion),
                new EntregaRealizada(vendedorId, salida, valorTotal)
        );
    }

    private List<DomainEvent> executor(VendedorId vendedorId, FacturaGenerada event, FacturaGeneradaUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(vendedorId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }
}