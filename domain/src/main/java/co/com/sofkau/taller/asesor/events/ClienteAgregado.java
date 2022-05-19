package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.Documento;
import co.com.sofkau.taller.vendedor.value.VendedorId;

public class ClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final VendedorId vendedorId;
    private final Documento documento;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;

    public ClienteAgregado(ClienteId clienteId, VendedorId vendedorId, Documento documento, Nombre nombre, Telefono telefono, Correo correo) {
        super("co.com.sofkau.taller.ClienteAgregado");
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Documento getDocumento() {
        return documento;
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
}
