package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.asesor.commands.AgregarAuto;

public class AgragarAutoUseCase extends UseCase<RequestCommand<AgregarAuto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarAuto> agregarAutoRequestCommand) {
        var command = agregarAutoRequestCommand.getCommand();

        var asesor = Asesor.from(command.getAsesorId(),
                repository().getEventsBy(command.getAsesorId().value()));

        asesor.agregarAuto(command.getMarca(), command.getPlaca());

        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
