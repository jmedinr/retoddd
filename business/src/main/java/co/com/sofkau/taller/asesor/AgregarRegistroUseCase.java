package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.asesor.commands.AgregarRegistro;

/**
 * Caso de uso para realizar un registro y autorizar el ingreso de un cliente
 */
public class AgregarRegistroUseCase extends UseCase<RequestCommand<AgregarRegistro>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarRegistro> agregarRegistroRequestCommand) {
        var command = agregarRegistroRequestCommand.getCommand();

        var asesor = Asesor.from(command.getAsesorId(),
                repository().getEventsBy(command.getAsesorId().value()));

        asesor.agregarRegistro(command.getTipoTrabajo(), command.getIngreso(),
                command.getAutorizacionCliente());

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
