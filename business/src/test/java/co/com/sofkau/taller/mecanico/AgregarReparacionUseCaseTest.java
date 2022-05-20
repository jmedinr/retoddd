package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.*;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AgregarReparacion;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.events.ReparacionAgregada;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.mecanico.value.ReparacionId;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarReparacionUseCaseTest {

    @InjectMocks
    AgregarReparacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarReparacionHappyPass() {
        var reparacionId = ReparacionId.of("87485");
        var mecanidoId = MecanicoId.of("1242");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.REPARACION);
        var estados = new Estados(Estados.Estado.ENPROCESO);
        var observacion = new Observacion("Se requiere cambio de palanquilla de luces y de motor");
        var command = new AgregarReparacion(reparacionId, mecanidoId, tipoTrabajo, estados, observacion);

        when(repository.getEventsBy("1242")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMecanicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ReparacionAgregada) events.get(0);
        Assertions.assertEquals(TipoTrabajo.Tipos.REPARACION,
                event.getTipoTrabajo().value());
    }

    private List<DomainEvent> history() {
        var vendedorId = VendedorId.of("741");
        var registroId = RegistroId.of("1012");
        var nombre = new Nombre("Wilson");
        var telefono = new Telefono("7845896854");
        var correo = new Correo("wilson@mecanico.com");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.REPARACION);
        var event = new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoTrabajo);
        event.setAggregateRootId("1242");
        return List.of(event);
    }
}