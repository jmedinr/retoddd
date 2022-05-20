package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.value.CompraId;
import co.com.sofkau.taller.vendedor.value.ValorCompra;

public class Compra extends Entity<CompraId> {
    protected ValorCompra valorCompra;

    public Compra(CompraId entityId, ValorCompra valorCompra) {
        super(entityId);
        this.valorCompra = valorCompra;
    }

    public ValorCompra getValorCompra() {
        return valorCompra;
    }
}
