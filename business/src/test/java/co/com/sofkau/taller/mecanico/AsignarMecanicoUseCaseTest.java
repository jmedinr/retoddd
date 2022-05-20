package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AsignarMecanico;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsignarMecanicoUseCaseTest {

    private AsignarMecanicoUseCase useCase;

    @BeforeEach
    public void setup(){ useCase = new AsignarMecanicoUseCase();}

    @Test
    public void asignarMecanicoHappyPass(){
        //arrange
        var vendedorId = VendedorId.of("741");
        var mecanidoId = MecanicoId.of("1242");
        var registroId = RegistroId.of("1012");
        var nombre = new Nombre("Wilson");
        var telefono = new Telefono("7845896854");
        var correo = new Correo("wilson@mecanico.com");
        var tipoTrabajo = new TipoTrabajo(TipoTrabajo.Tipos.REPARACION);
        var command = new AsignarMecanico(vendedorId,mecanidoId,registroId,nombre,telefono,correo,tipoTrabajo);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var mecanicoAsignado = (MecanicoAsignado)events.get(0);
        Assertions.assertEquals("1242",mecanicoAsignado.aggregateRootId());
        Assertions.assertEquals("Wilson",mecanicoAsignado.getNombre().value());
        Assertions.assertEquals("7845896854",mecanicoAsignado.getTelefono().value());
        Assertions.assertEquals("wilson@mecanico.com",mecanicoAsignado.getCorreo().value());
    }
}