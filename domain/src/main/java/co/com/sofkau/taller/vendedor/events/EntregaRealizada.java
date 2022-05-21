package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.Salida;
import co.com.sofkau.taller.vendedor.value.ValorTotal;
import co.com.sofkau.taller.vendedor.value.VendedorId;

/**
 * Evento lanzado al autorizar la salida de un vehiculo
 */
public class EntregaRealizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final Salida salida;
    private final ValorTotal valorTotal;

    public EntregaRealizada(VendedorId vendedorId, Salida salida, ValorTotal valorTotal) {
        super("co.com.sofkau.taller.EntregaRealizada");
        this.vendedorId = vendedorId;
        this.salida = salida;
        this.valorTotal = valorTotal;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Salida getSalida() {
        return salida;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
