package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Estados;
import co.com.sofkau.generic.values.Observacion;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.Inspeccion;
import co.com.sofkau.taller.mecanico.value.GarantiaId;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class GarantiaFinalizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final GarantiaId garantiaId;
    private final Estados estados;
    private final Observacion observacion;
    private final Map<InspeccionId, Inspeccion> inspeccionMap;

    public GarantiaFinalizada(VendedorId vendedorId, RegistroId registroId, GarantiaId garantiaId, Estados estados, Observacion observacion, Map<InspeccionId, Inspeccion> inspeccionMap) {
        super("co.com.sofkau.taller.GarantiaFinalizada");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.garantiaId = garantiaId;
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

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Estados getEstados() {
        return estados;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
