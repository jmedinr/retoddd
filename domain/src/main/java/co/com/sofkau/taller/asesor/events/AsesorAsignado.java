package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

/**
 * Esta clase es un evento de dominio que se lanza cuando se asigna un asesor
 */
public class AsesorAsignado extends DomainEvent {
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;


    public AsesorAsignado(Nombre nombre, Telefono telefono, Correo correo, MecanicoId mecanicoId, VendedorId vendedorId) {
        super("co.com.sofkau.taller.AsesorAsignado");
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
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

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
