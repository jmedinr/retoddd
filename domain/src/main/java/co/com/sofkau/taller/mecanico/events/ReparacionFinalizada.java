package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.Inspeccion;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.ReparacionId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class ReparacionFinalizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final ReparacionId reparacionId;
    private final Estados estados;
    private final Observacion observacion;
    private final Map<InspeccionId, Inspeccion> inspeccionMap;


    public ReparacionFinalizada(VendedorId vendedorId, RegistroId registroId, ReparacionId reparacionId, Estados estados, Observacion observacion, Map<InspeccionId, Inspeccion> inspeccionMap) {
        super("co.com.sofkau.taller.ReparacionFinalizada");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.reparacionId = reparacionId;
        this.estados = estados;
        this.observacion = observacion;
        this.inspeccionMap = inspeccionMap;
    }

    public Map<InspeccionId, Inspeccion> getInspeccionMap() {
        return inspeccionMap;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
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
}
