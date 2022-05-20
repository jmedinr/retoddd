package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Set;

public class VendedorAsignado extends DomainEvent {
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final Set<Cliente> clienteSet;
    private final Set<Auto> autoSet;
    private final Set<ListaRepuestos> listaRepuestosSet;

    public VendedorAsignado(VendedorId vendedorId, Nombre nombre, Telefono telefono, Correo correo,
                            Set<Cliente> clienteSet, Set<Auto> autoSet, Set<ListaRepuestos> listaRepuestosSet) {
        super("co.com.sofkau.taller.VendedorAsignado");
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.clienteSet = clienteSet;
        this.autoSet = autoSet;
        this.listaRepuestosSet = listaRepuestosSet;
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

    public Set<Cliente> getClienteSet() {
        return clienteSet;
    }

    public Set<Auto> getAutoSet() {
        return autoSet;
    }

    public Set<ListaRepuestos> getListaRepuestosSet() {
        return listaRepuestosSet;
    }
}
