package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.mecanico.value.Diagnostico;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;

import java.util.Set;

public class Inspeccion extends Entity<InspeccionId> {
    protected Diagnostico diagnostico;
    protected Set<ListaRepuestos> listaRepuestosSet;

    public Inspeccion(InspeccionId entityId, Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestosSet) {
        super(entityId);
        this.diagnostico = diagnostico;
        this.listaRepuestosSet = listaRepuestosSet;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Set<ListaRepuestos> getListaRepuestosSet() {
        return listaRepuestosSet;
    }

    public void setListaRepuestosSet(Set<ListaRepuestos> listaRepuestosSet) {
        this.listaRepuestosSet = listaRepuestosSet;
    }
}
