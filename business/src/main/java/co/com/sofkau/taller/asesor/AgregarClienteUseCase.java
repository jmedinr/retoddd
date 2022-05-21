package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.asesor.commands.AgregarCliente;

/**
 * Caso de uso para agregar un cliente
 */
public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();

        var asesor = Asesor.from(command.getAsesorId(),
                repository().getEventsBy(command.getAsesorId().value()));

        asesor.agregarCliente(
                command.getDocumento(),
                command.getNombre(),
                command.getTelefono(),
                command.getCorreo()
        );

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
