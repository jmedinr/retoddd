package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.MetodoPago;
import co.com.sofkau.taller.vendedor.value.TipoPago;
import co.com.sofkau.taller.vendedor.value.ValorReparacion;

public class VentaGenerada extends DomainEvent {
    private final TipoPago tipoPago;
    private final MetodoPago metodoPago;
    private final ValorReparacion valorReparacion;

    public VentaGenerada(TipoPago tipoPago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        super("co.com.sofkau.taller.VentaGenerada");
        this.tipoPago = tipoPago;
        this.metodoPago = metodoPago;
        this.valorReparacion = valorReparacion;
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
