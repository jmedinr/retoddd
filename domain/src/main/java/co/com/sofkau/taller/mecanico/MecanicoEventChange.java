package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.mecanico.events.GarantiaAgregada;
import co.com.sofkau.taller.mecanico.events.InspeccionAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.events.ReparacionAgregada;

import java.util.HashMap;

/**
 * Controlados de eventos del agregado Mecanico
 */
public class MecanicoEventChange extends EventChange {
    public MecanicoEventChange(Mecanico mecanico) {
        apply((MecanicoAsignado event) -> {
            mecanico.nombre = event.getNombre();
            mecanico.telefono = event.getTelefono();
            mecanico.correo = event.getCorreo();
            mecanico.tipoTrabajo = event.getTipoTrabajo();
            mecanico.garantiaMap = new HashMap<>();
            mecanico.inspeccionMap = new HashMap<>();
            mecanico.reparacionMap = new HashMap<>();
            mecanico.vendedorId = event.getVendedorId();
        });
        apply((InspeccionAgregada event) -> {
            var inspeccionId = event.getInspeccionId();
            var inspeccion = new Inspeccion(inspeccionId, event.getDiagnostico(), event.getListaRepuestosSet());
            mecanico.inspeccionMap.put(inspeccionId, inspeccion);
        });
        apply((ReparacionAgregada event) -> {
            var repacionId = event.getReparacionId();
            var reparacion = new Reparacion(repacionId, event.getEstados(), event.getObservacion());
            mecanico.reparacionMap.put(repacionId, reparacion);
        });
        apply((GarantiaAgregada event) -> {
            var garantiaId = event.getGarantiaId();
            var garantia = new Garantia(garantiaId, event.getEstados(), event.getObservacion());
            mecanico.garantiaMap.put(garantiaId, garantia);
        });
    }
}
