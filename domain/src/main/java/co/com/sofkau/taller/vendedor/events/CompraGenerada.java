package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.ValorCompra;

public class CompraGenerada extends DomainEvent {
    private final ValorCompra valorCompra;

    public CompraGenerada(ValorCompra valorCompra) {
        super("co.com.sofkau.taller.CompraGenerada");
        this.valorCompra = valorCompra;
    }

    public ValorCompra getValorCompra() {
        return valorCompra;
    }
}
