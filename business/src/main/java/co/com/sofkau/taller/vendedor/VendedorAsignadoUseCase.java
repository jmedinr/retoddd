package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.VendedorAsignado;

/**
 * Caso de uso para asignar un vendedor a un cliente
 */
public class VendedorAsignadoUseCase extends UseCase<TriggeredEvent<VendedorAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VendedorAsignado> vendedorAsignadoTriggeredEvent) {
        var event = vendedorAsignadoTriggeredEvent.getDomainEvent();

        var vendedor = new Vendedor(event.getVendedorId(), event.getNombre(),
                event.getTelefono(), event.getCorreo(), event.getClienteSet(),
                event.getAutoSet(), event.getListaRepuestosSet());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
