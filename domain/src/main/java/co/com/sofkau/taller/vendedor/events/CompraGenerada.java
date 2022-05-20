package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.ValorCompra;
import co.com.sofkau.taller.vendedor.value.VendedorId;

public class CompraGenerada extends DomainEvent {
    private final VendedorId vendedorId;
    private final ValorCompra valorCompra;

    public CompraGenerada(VendedorId vendedorId, ValorCompra valorCompra) {
        super("co.com.sofkau.taller.CompraGenerada");
        this.vendedorId = vendedorId;
        this.valorCompra = valorCompra;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public ValorCompra getValorCompra() {
        return valorCompra;
    }
}
