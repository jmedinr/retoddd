package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.commands.AgregarAuto;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.events.AutoAgregado;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.Marca;
import co.com.sofkau.taller.asesor.value.Placa;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
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
class AgregarAutoUseCaseTest {

    @InjectMocks
    AgregarAutoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarAutoHappyPass() {
        //arrange
        var autoId = AutoId.of("88");
        var asesorId = AsesorId.of("1010");
        var marca = new Marca("Chevrolet");
        var placa = new Placa("XYZ785");
        var command = new AgregarAuto(autoId, asesorId, marca, placa);

        when(repository.getEventsBy("1010")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAsesorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AutoAgregado) events.get(0);
        Assertions.assertEquals("Chevrolet", event.getMarca().value());
        Assertions.assertEquals("XYZ785", event.getPlaca().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("Juan");
        var telefono = new Telefono("0001458745");
        var correo = new Correo("juand@taller.com");
        var mecanicoId = MecanicoId.of("1242");
        var vendedorId = VendedorId.of("741");

        var event = new AsesorAsignado(nombre, telefono, correo, mecanicoId, vendedorId);
        event.setAggregateRootId("1010");
        return List.of(event);
    }

}