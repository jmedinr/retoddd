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

        var vendedor = Vendedor.from(
                event.getVendedorId(),
                repository().getEventsBy(event.getVendedorId().value())
        );

        FacturaFactory factory = FacturaFactory.builder()
                .agregarFactura(
                        event.getFacturaId(),event.getVendedorId(),event.getDatosCliente(),event.getDatosEmpresa(),
                        event.getDatosAuto(), event.getListaRepuestosSet(), event.getValorCompra(),
                        event.getValorReparacion(),event.getValorTotal()
                );

        vendedor.crearFactura(event.getFacturaId(),
                event.getVendedorId(), factory.factura().stream().iterator().next().getDatosCliente(),
                factory.factura().stream().iterator().next().getDatosEmpresa(),
                factory.factura().stream().iterator().next().getDatosAuto(),
                factory.factura().stream().iterator().next().getListaRepuestosSet(),
                factory.factura().stream().iterator().next().getValorCompra(),
                factory.factura().stream().iterator().next().getValorReparacion(),
                factory.factura().stream().iterator().next().getValorTotal()
                );

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
