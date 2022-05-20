package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.Inspeccion;
import co.com.sofkau.taller.mecanico.value.GarantiaId;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class FinalizarGarantia extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final GarantiaId garantiaId;
    private final Estados estados;
    private final Observacion observacion;
    private final Map<InspeccionId, Inspeccion> inspeccionMap;


    public FinalizarGarantia(VendedorId vendedorId, MecanicoId mecanicoId,
                             RegistroId registroId, GarantiaId garantiaId,
                             Estados estados, Observacion observacion,
                             Map<InspeccionId, Inspeccion> inspeccionMap) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.garantiaId = garantiaId;
        this.estados = estados;
        this.observacion = observacion;
        this.inspeccionMap = inspeccionMap;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Estados getEstados() {
        return estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public Map<InspeccionId, Inspeccion> getInspeccionMap() {
        return inspeccionMap;
    }
}
