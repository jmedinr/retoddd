package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.events.FacturaGenerada;
import co.com.sofkau.taller.vendedor.value.FacturaId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.List;

public class Factura extends Entity<FacturaId> {
    protected List<FacturaGenerada.TuplaFactura> tuplaFacturas;
    protected VendedorId vendedorId;

    public Factura(FacturaId entityId, List<FacturaGenerada.TuplaFactura> tuplaFacturas, VendedorId vendedorId) {
        super(entityId);
        this.tuplaFacturas = tuplaFacturas;
        this.vendedorId = vendedorId;
    }

    public List<FacturaGenerada.TuplaFactura> getTuplaFacturas() {
        return tuplaFacturas;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
