package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.CompraGenerada;

public class CompraGeneradaUseCase extends UseCase<TriggeredEvent<CompraGenerada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CompraGenerada> compraGeneradaTriggeredEvent) {
        var event = compraGeneradaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.getVendedorId(),
                repository().getEventsBy(event.getVendedorId().value())
        );

        vendedor.crearCompra(event.getVendedorId(), event.getValorCompra());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
