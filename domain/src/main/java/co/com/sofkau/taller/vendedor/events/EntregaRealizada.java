package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.value.Salida;
import co.com.sofkau.taller.vendedor.value.ValorTotal;

public class EntregaRealizada extends DomainEvent {
    private final Salida salida;
    private final ValorTotal valorTotal;

    public EntregaRealizada(Salida salida, ValorTotal valorTotal) {
        super("co.com.sofkau.taller.EntregaRealizada");
        this.salida = salida;
        this.valorTotal = valorTotal;
    }

    public Salida getSalida() {
        return salida;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
