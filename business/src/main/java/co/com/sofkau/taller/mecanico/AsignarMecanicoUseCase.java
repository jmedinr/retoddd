package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AsignarMecanico;

/**
 * Caso de uso para que un mecanico sea asignado a un cliente
 */
public class AsignarMecanicoUseCase extends UseCase<RequestCommand<AsignarMecanico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarMecanico> asignarMecanicoRequestCommand) {
        var command = asignarMecanicoRequestCommand.getCommand();

        var mecanico = new Mecanico(command.getMecanicoId(), command.getVendedorId(), command.getRegistroId(),
                command.getNombre(), command.getCorreo(), command.getTelefono(), command.getTipoTrabajo());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
