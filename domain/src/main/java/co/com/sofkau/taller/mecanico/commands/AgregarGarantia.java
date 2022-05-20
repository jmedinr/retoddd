package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.mecanico.value.GarantiaId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;

public class AgregarGarantia extends Command {
    private final GarantiaId garantiaId;
    private final MecanicoId mecanicoId;
    private final Estados estados;
    private final Observacion observacion;


    public AgregarGarantia(GarantiaId garantiaId, MecanicoId mecanicoId,
                           Estados estados, Observacion observacion) {
        this.garantiaId = garantiaId;
        this.mecanicoId = mecanicoId;
        this.estados = estados;
        this.observacion = observacion;
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
