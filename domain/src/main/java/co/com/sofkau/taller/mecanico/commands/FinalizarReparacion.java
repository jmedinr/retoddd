package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.generic.values.TipoTrabajo;
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
    private final InspeccionId inspeccionId;
    private final TipoTrabajo tipoTrabajo;
    private final Estados estados;
    private final Observacion observacion;

    public FinalizarReparacion(VendedorId vendedorId, MecanicoId mecanicoId, RegistroId registroId,
                               ReparacionId reparacionId, InspeccionId inspeccionId,
                               TipoTrabajo tipoTrabajo, Estados estados,
                               Observacion observacion) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.reparacionId = reparacionId;
        this.tipoTrabajo = tipoTrabajo;
        this.estados = estados;
        this.observacion = observacion;
        this.inspeccionId = inspeccionId;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
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

    public InspeccionId getInspeccionId() {
        return inspeccionId;
    }
}
