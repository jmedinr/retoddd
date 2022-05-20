package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarReparacion;

public class AgregarReparacionUseCase extends UseCase<RequestCommand<AgregarReparacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReparacion> agregarReparacionRequestCommand) {
        var command = agregarReparacionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.agregarTarea(command.getTipoTrabajo(), command.getEstados(), command.getObservacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
