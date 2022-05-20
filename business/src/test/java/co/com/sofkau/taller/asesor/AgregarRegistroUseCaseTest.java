package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.commands.AgregarRegistro;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.events.AutoAgregado;
import co.com.sofkau.taller.asesor.events.ClienteAgregado;
import co.com.sofkau.taller.asesor.events.RegistroExitoso;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarRegistroUseCaseTest {

    @InjectMocks
    AgregarRegistroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarRegistroHappyPass(){
        //arrange
        var registroId = RegistroId.of("1012");
        var asesorId = AsesorId.of("1010");
        var clienteId = ClienteId.of("875");
        var autoId = AutoId.of("88");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.REPARACION);
        var ingreso = new Ingreso(LocalDateTime.now(), LocalDate.now());
        var autorizacionCliente = new AutorizacionCliente(AutorizacionCliente.Autorizacion.AUTORIZADO);
        var command = new AgregarRegistro(registroId,asesorId,clienteId,autoId,tipoTrabajo,ingreso,
                autorizacionCliente);

        when(repository.getEventsBy("1010")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAsesorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RegistroExitoso)events.get(0);
        Assertions.assertEquals(AutorizacionCliente.Autorizacion.AUTORIZADO,event.getAutorizacionCliente().value());

    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("Juan");
        var telefono = new Telefono("0001458745");
        var correo = new Correo("juand@taller.com");
        var mecanicoId = MecanicoId.of("1242");
        var vendedorId = VendedorId.of("741");

        var event = new AsesorAsignado(nombre,telefono,correo,mecanicoId,vendedorId);

        var clienteId = ClienteId.of("875");
        var documento = new Documento("78459524");

        var event2 = new ClienteAgregado(clienteId,documento,nombre,telefono,correo);

        var autoId = AutoId.of("88");
        var marca = new Marca("Chevrolet");
        var placa = new Placa("XYZ785");

        var event3 = new AutoAgregado(autoId,marca,placa);

        event.setAggregateRootId("1010");
        return List.of(event,event2,event3);
    }

}