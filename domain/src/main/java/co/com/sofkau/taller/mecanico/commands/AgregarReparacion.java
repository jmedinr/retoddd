package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.mecanico.value.ReparacionId;

public class AgregarReparacion extends Command {
    private final ReparacionId reparacionId;
    private final MecanicoId mecanicoId;
    private final TipoTrabajo tipoTrabajo;
    private final Estados estados;
    private final Observacion observacion;


    public AgregarReparacion(ReparacionId reparacionId, MecanicoId mecanicoId,
                             TipoTrabajo tipoTrabajo, Estados estados, Observacion observacion) {
        this.reparacionId = reparacionId;
        this.mecanicoId = mecanicoId;
        this.tipoTrabajo = tipoTrabajo;
        this.estados = estados;
        this.observacion = observacion;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public ReparacionId getReparacionId() {
        return reparacionId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public Estados getEstados() {
        return estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
