package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.commands.AsignarAsesor;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearAsesorUseCaseTest {

    private CrearAsesorUseCase useCase;

    @BeforeEach
    public void setup(){ useCase = new CrearAsesorUseCase();}

    @Test
    public void crearAsesorHappyPass(){
        //arrange
        var asesorId = AsesorId.of("1010");
        var mecanidoId = MecanicoId.of("1242");
        var vendedorId = VendedorId.of("741");
        var nombre = new Nombre("Juan");
        var correo = new Correo("juand@taller.com");
        var telefono = new Telefono("0001458745");
        var command = new AsignarAsesor(asesorId,mecanidoId,vendedorId,nombre,correo,telefono);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var asesorAsignado = (AsesorAsignado)events.get(0);
        Assertions.assertEquals("1010",asesorAsignado.aggregateRootId());
        Assertions.assertEquals("Juan",asesorAsignado.getNombre().value());
        Assertions.assertEquals("juand@taller.com",asesorAsignado.getCorreo().value());
    }

}