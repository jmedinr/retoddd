package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.FacturaGenerada;
import co.com.sofkau.taller.vendedor.factory.FacturaFactory;

public class FacruraGeneradaUseCase extends UseCase<TriggeredEvent<FacturaGenerada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FacturaGenerada> facturaGeneradaTriggeredEvent) {
        var event = facturaGeneradaTriggeredEvent.getDomainEvent();

        var factory = FacturaFactory.builder();

        event.getTuplaFacturas().forEach(tuplaFactura -> factory.agregarFactura(
                tuplaFactura.getFacturaId(), tuplaFactura.getDatosCliente(), tuplaFactura.getDatosEmpresa(),
                tuplaFactura.getDatosAuto(), tuplaFactura.getListaRepuestosSet(), tuplaFactura.getValorCompra(),
                tuplaFactura.getValorReparacion(), tuplaFactura.getValorTotal()));

        var vendedor = Vendedor.from(
                event.getVendedorId(),
                repository().getEventsBy(event.getVendedorId().value())
        );

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
