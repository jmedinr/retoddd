package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.mecanico.value.ReparacionId;

public class Reparacion extends Entity<ReparacionId> {
    protected Estados estados;
    protected Observacion observacion;

    public Reparacion(ReparacionId entityId, Estados estados, Observacion observacion) {
        super(entityId);
        this.estados = estados;
        this.observacion = observacion;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }
}
