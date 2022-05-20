package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.*;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.events.*;
import co.com.sofkau.taller.mecanico.value.*;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mecanico extends AggregateEvent<MecanicoId> {
    protected VendedorId vendedorId;
    protected RegistroId registroId;
    protected Nombre nombre;
    protected Correo correo;
    protected Telefono telefono;
    protected TipoTrabajo tipoTrabajo;
    protected Map<InspeccionId, Inspeccion> inspeccionMap;
    protected Map<ReparacionId, Reparacion> reparacionMap;
    protected Map<GarantiaId, Garantia> garantiaMap;

    public Mecanico(MecanicoId entityId, VendedorId vendedorId, RegistroId registroId, Nombre nombre,
                    Correo correo, Telefono telefono, TipoTrabajo tipoTrabajo) {
        super(entityId);
        appendChange(new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoTrabajo)).apply();
        subscribe(new MecanicoEventChange(this));
    }

    private Mecanico(MecanicoId entityId) {
        super(entityId);
        subscribe(new MecanicoEventChange(this));
    }

    public static Mecanico from(MecanicoId entityId, List<DomainEvent> events) {
        var curso = new Mecanico(entityId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarInspeccion(Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestosSet) {
        var InspeccionId = new InspeccionId();
        appendChange(new InspeccionAgregada(InspeccionId, diagnostico, listaRepuestosSet));
    }

    public void agregarTarea(TipoTrabajo tipoTrabajo, Estados estados, Observacion observacion) {
        if (tipoTrabajo.value().equals(TipoTrabajo.Tipos.REPARACION) && estados.value().equals(Estados.Estado.ENPROCESO)) {
            var reparacionId = new ReparacionId();
            appendChange(new ReparacionAgregada(reparacionId, tipoTrabajo, estados, observacion));
        }
        else if (tipoTrabajo.value().equals(TipoTrabajo.Tipos.GARANTIA) && estados.value().equals(Estados.Estado.ENPROCESO)) {
            var garantiaId = new GarantiaId();
            appendChange(new GarantiaAgregada(garantiaId, tipoTrabajo, estados, observacion));
        }else {
            throw new IllegalArgumentException("El trabajo ya fue finalizado");
        }

    }

    public void finalizarTarea(TipoTrabajo tipoTrabajo, Observacion observacion) {
        if (tipoTrabajo.value().equals(TipoTrabajo.Tipos.REPARACION)) {
            var idReparacion = reparacionMap.keySet().
                    stream().
                    iterator().
                    next();
            var estadoFinalizado = reparacionMap.get(idReparacion)
                    .estados
                    .finalizar();
            appendChange(new ReparacionFinalizada(vendedorId, registroId, idReparacion, estadoFinalizado, observacion, inspeccionMap));
        }
        if (tipoTrabajo.value().equals(TipoTrabajo.Tipos.GARANTIA)) {
            var idGarantia = garantiaMap.keySet().
                    stream().
                    iterator().
                    next();
            var estadoFinalizado = garantiaMap.get(idGarantia)
                    .estados
                    .finalizar();
            appendChange(new GarantiaFinalizada(vendedorId, registroId, idGarantia, estadoFinalizado, observacion, inspeccionMap));
        }
    }
}
