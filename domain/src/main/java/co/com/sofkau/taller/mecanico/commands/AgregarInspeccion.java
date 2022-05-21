package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.mecanico.value.Diagnostico;
import co.com.sofkau.taller.mecanico.value.InspeccionId;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.mecanico.value.MecanicoId;

import java.util.Set;

/**
 * Comando para iniciar una inspeccion y tener un diagnotisco de las fallas del auto
 */
public class AgregarInspeccion extends Command {
    private final InspeccionId inspeccionId;
    private final MecanicoId mecanicoId;
    private final Diagnostico diagnostico;
    private final Set<ListaRepuestos> listaRepuestosSet;

    public AgregarInspeccion(InspeccionId inspeccionId, MecanicoId mecanicoId,
                             Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestosSet) {
        this.inspeccionId = inspeccionId;
        this.mecanicoId = mecanicoId;
        this.diagnostico = diagnostico;
        this.listaRepuestosSet = listaRepuestosSet;
    }

    public InspeccionId getInspeccionId() {
        return inspeccionId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public Set<ListaRepuestos> getListaRepuestosSet() {
        return listaRepuestosSet;
    }
}
