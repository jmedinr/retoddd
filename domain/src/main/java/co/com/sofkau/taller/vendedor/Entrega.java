package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.value.EntregaId;
import co.com.sofkau.taller.vendedor.value.Salida;
import co.com.sofkau.taller.vendedor.value.ValorTotal;

/**
 * Entidad que autoriza la salida de un vehiculo
 */
public class Entrega extends Entity<EntregaId> {
    protected Salida salida;
    protected ValorTotal valorTotal;

    public Entrega(EntregaId entityId, Salida salida, ValorTotal valorTotal) {
        super(entityId);
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
