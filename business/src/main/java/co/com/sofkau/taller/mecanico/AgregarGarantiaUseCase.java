package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarGarantia;

/**
 * Caso de uso para realizar una garantia
 */
public class AgregarGarantiaUseCase extends UseCase<RequestCommand<AgregarGarantia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGarantia> agregarGarantiaRequestCommand) {
        var command = agregarGarantiaRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.agregarTarea(command.getTipoTrabajo(), command.getEstados(), command.getObservacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
