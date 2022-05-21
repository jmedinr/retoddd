package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.FinalizarGarantia;

/**
 * Caso de uso para que una garantia sea iniciada
 */
public class FinalizarGarantiaUseCase extends UseCase<RequestCommand<FinalizarGarantia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<FinalizarGarantia> finalizarGarantiaRequestCommand) {
        var command = finalizarGarantiaRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.finalizarTarea(command.getTipoTrabajo(), command.getObservacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
