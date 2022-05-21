package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

/**
 * Evento que se lanza cuando se asigna un mecanico
 */
public class MecanicoAsignado extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final TipoTrabajo tipoTrabajo;


    public MecanicoAsignado(VendedorId vendedorId, RegistroId registroId, Nombre nombre, Telefono telefono, Correo correo,
                            TipoTrabajo tipoTrabajo) {
        super("co.com.sofkau.taller.MecanicoAgregado");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoTrabajo = tipoTrabajo;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
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
