package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.value.Diagnostico;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;

import java.util.Set;

public class InspeccionAgregada extends DomainEvent {
    private final InspeccionId inspeccionId;
    private final Diagnostico diagnostico;
    private final Set<ListaRepuestos> listaRepuestosSet;

    public InspeccionAgregada(InspeccionId inspeccionId, Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestosSet) {
        super("co.com.sofkau.taller.InspeccionAgregada");
        this.inspeccionId = inspeccionId;
        this.diagnostico = diagnostico;
        this.listaRepuestosSet = listaRepuestosSet;
    }

    public InspeccionId getInspeccionId() {
        return inspeccionId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public Set<ListaRepuestos> getListaRepuestosSet() {
        return listaRepuestosSet;
    }
}
