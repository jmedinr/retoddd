package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarInspeccion;

public class AgregarInspeccionUseCase extends UseCase<RequestCommand<AgregarInspeccion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInspeccion> agregarInspeccionRequestCommand) {
        var command = agregarInspeccionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.agregarInspeccion(command.getDiagnostico(), command.getListaRepuestosSet());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
