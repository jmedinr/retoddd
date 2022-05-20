package co.com.sofkau.taller.asesor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.asesor.commands.AsignarAsesor;

public class CrearAsesorUseCase extends UseCase<RequestCommand<AsignarAsesor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarAsesor> asignarAsesorRequestCommand) {
        var command = asignarAsesorRequestCommand.getCommand();

        var asesor = new Asesor(
                command.getAsesorId(),
                command.getMecanicoId(),
                command.getVendedorId(),
                command.getNombre(),
                command.getCorreo(),
                command.getTelefono()
                );
        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}
