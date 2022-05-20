package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.commands.AgregarCliente;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.events.ClienteAgregado;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.Documento;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarClienteUseCaseTest {

    @InjectMocks
    AgregarClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarClienteHappyPass(){
        //arrange
        var clienteId = ClienteId.of("875");
        var asesorId = AsesorId.of("1010");
        var documento = new Documento("78459524");
        var nombre = new Nombre("Pepito");
        var telefono = new Telefono("7845879856");
        var correo = new Correo("pepito@cliente.com");
        var command = new AgregarCliente(clienteId,asesorId,documento,nombre,telefono,correo);

        when(repository.getEventsBy("1010")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAsesorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClienteAgregado)events.get(0);
        Assertions.assertEquals("7845879856",event.getTelefono().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("Juan");
        var telefono = new Telefono("0001458745");
        var correo = new Correo("juand@taller.com");
        var mecanicoId = MecanicoId.of("1242");
        var vendedorId = VendedorId.of("741");

        var event = new AsesorAsignado(nombre,telefono,correo,mecanicoId,vendedorId);
        event.setAggregateRootId("1010");
        return List.of(event);
    }
}