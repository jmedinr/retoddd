package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.MetodoPago;
import co.com.sofkau.taller.vendedor.value.TipoPago;
import co.com.sofkau.taller.vendedor.value.ValorReparacion;
import co.com.sofkau.taller.vendedor.value.VendedorId;

/**
 * Evento lanzado cuando se genera el cobro de una reparacion
 */
public class VentaGenerada extends DomainEvent {
    private final VendedorId vendedorId;
    private final TipoPago tipoPago;
    private final MetodoPago metodoPago;
    private final ValorReparacion valorReparacion;

    public VentaGenerada(VendedorId vendedorId, TipoPago tipoPago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        super("co.com.sofkau.taller.VentaGenerada");
        this.vendedorId = vendedorId;
        this.tipoPago = tipoPago;
        this.metodoPago = metodoPago;
        this.valorReparacion = valorReparacion;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public ValorReparacion getValorReparacion() {
        return valorReparacion;
    }
}
