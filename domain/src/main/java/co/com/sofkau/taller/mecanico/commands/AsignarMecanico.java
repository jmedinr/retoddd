package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

public class AsignarMecanico extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final TipoTrabajo tipoTrabajo;

    public AsignarMecanico(VendedorId vendedorId, MecanicoId mecanicoId, RegistroId registroId,
                           Nombre nombre, Telefono telefono, Correo correo, TipoTrabajo tipoTrabajo) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoTrabajo = tipoTrabajo;
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

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Correo getCorreo() {
        return correo;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }
}
