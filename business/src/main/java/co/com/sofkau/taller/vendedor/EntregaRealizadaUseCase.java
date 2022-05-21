package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.EntregaRealizada;

/**
 * Caso de uso para autorizar la salida de auto por parte de un vendedor
 */
public class EntregaRealizadaUseCase extends UseCase<TriggeredEvent<EntregaRealizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EntregaRealizada> entregaRealizadaTriggeredEvent) {
        var event = entregaRealizadaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.getVendedorId(),
                repository().getEventsBy(event.getVendedorId().value())
        );

        vendedor.crearEntrega(event.getVendedorId(), event.getSalida(), event.getValorTotal());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
