package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.VentaGenerada;

public class VentaGeneradaUseCase extends UseCase<TriggeredEvent<VentaGenerada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VentaGenerada> ventaGeneradaTriggeredEvent) {
        var event = ventaGeneradaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.getVendedorId(),
                repository().getEventsBy(event.getVendedorId().value())
        );

        vendedor.crearVenta(event.getVendedorId(), event.getTipoPago(), event.getMetodoPago(),
                event.getValorReparacion());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
