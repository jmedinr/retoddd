package co.com.sofkau.taller.vendedor;


import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.value.MetodoPago;
import co.com.sofkau.taller.vendedor.value.TipoPago;
import co.com.sofkau.taller.vendedor.value.ValorReparacion;
import co.com.sofkau.taller.vendedor.value.VentaId;

/**
 * Entidad que representa una venta de una reparacion realizada
 */
public class Venta extends Entity<VentaId> {
    protected TipoPago tipoPago;
    protected MetodoPago metodoPago;
    protected ValorReparacion valorReparacion;

    public Venta(VentaId entityId, TipoPago tipoPago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        super(entityId);
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
