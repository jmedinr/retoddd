package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.mecanico.value.GarantiaId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;

/**
 * Comando para agregar una garantia de una reparacion
 */
public class AgregarGarantia extends Command {
    private final GarantiaId garantiaId;
    private final MecanicoId mecanicoId;
    private final TipoTrabajo tipoTrabajo;
    private final Estados estados;
    private final Observacion observacion;


    public AgregarGarantia(GarantiaId garantiaId, MecanicoId mecanicoId,
                           TipoTrabajo tipoTrabajo, Estados estados, Observacion observacion) {
        this.garantiaId = garantiaId;
        this.mecanicoId = mecanicoId;
        this.tipoTrabajo = tipoTrabajo;
        this.estados = estados;
        this.observacion = observacion;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
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
