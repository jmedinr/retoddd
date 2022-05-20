package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.*;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.commands.FinalizarGarantia;
import co.com.sofkau.taller.mecanico.events.GarantiaAgregada;
import co.com.sofkau.taller.mecanico.events.GarantiaFinalizada;
import co.com.sofkau.taller.mecanico.events.InspeccionAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.value.*;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinalizarGarantiaUseCaseTest {

    @InjectMocks
    FinalizarGarantiaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void finalizarGarantiaHappyPass() {

        var vendedorId = VendedorId.of("741");
        var mecanidoId = MecanicoId.of("1242");
        var registroId = RegistroId.of("1012");
        var gatantiaId = GarantiaId.of("105");
        var inspeccionId = InspeccionId.of("47852");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.GARANTIA);
        var estados = new Estados(Estados.Estado.ENPROCESO);
        var observacion = new Observacion("quedó mal instalada la palanquilla");
        var command = new FinalizarGarantia(vendedorId, mecanidoId, registroId, gatantiaId, inspeccionId,
                tipoTrabajo, estados, observacion);

        when(repository.getEventsBy("1242")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMecanicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (GarantiaFinalizada) events.get(0);
        Assertions.assertEquals(Estados.Estado.FINALIZADO, event.getEstados().value());
    }

    private List<DomainEvent> history() {
        var vendedorId = VendedorId.of("741");
        var registroId = RegistroId.of("1012");
        var nombre = new Nombre("Wilson");
        var telefono = new Telefono("7845896854");
        var correo = new Correo("wilson@mecanico.com");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.GARANTIA);

        var event = new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoTrabajo);

        var inspeccionId = InspeccionId.of("47852");
        var diagnostico = new Diagnostico("palanquilla de luces requiere cambio, motor malo");
        Set<ListaRepuestos> listaRepuestosSet = new HashSet<>();
        var repuesto1 = new ListaRepuestos("Palanquilla de luces nuevo");
        var repuesto2 = new ListaRepuestos("motor v8 nuevo");
        listaRepuestosSet.add(repuesto1);
        listaRepuestosSet.add(repuesto2);

        var event2 = new InspeccionAgregada(inspeccionId, diagnostico, listaRepuestosSet);

        var gatantiaId = GarantiaId.of("105");
        var estados = new Estados(Estados.Estado.ENPROCESO);
        var observacion = new Observacion("quedó mal instalada la palanquilla");

        var event3 = new GarantiaAgregada(gatantiaId, tipoTrabajo, estados, observacion);

        event.setAggregateRootId("1242");
        return List.of(event, event2, event3);
    }

}