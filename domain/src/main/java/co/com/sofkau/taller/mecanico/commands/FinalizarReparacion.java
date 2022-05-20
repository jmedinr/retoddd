package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.Inspeccion;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.mecanico.value.ReparacionId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class FinalizarReparacion extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final ReparacionId reparacionId;
    private final Estados estados;
    private final Observacion observacion;
    private final Map<InspeccionId, Inspeccion> inspeccionMap;

    public FinalizarReparacion(VendedorId vendedorId, MecanicoId mecanicoId, RegistroId registroId,
                               ReparacionId reparacionId, Estados estados,
                               Observacion observacion, Map<InspeccionId, Inspeccion> inspeccionMap) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.reparacionId = reparacionId;
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

    public ReparacionId getReparacionId() {
        return reparacionId;
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
