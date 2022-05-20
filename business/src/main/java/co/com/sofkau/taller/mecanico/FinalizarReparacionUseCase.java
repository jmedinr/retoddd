package co.com.sofkau.taller.mecanico;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.FinalizarReparacion;

public class FinalizarReparacionUseCase extends UseCase<RequestCommand<FinalizarReparacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<FinalizarReparacion> finalizarReparacionRequestCommand) {
        var command = finalizarReparacionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.finalizarTarea(command.getTipoTrabajo(), command.getObservacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
