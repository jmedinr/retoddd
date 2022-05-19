package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.Documento;
import co.com.sofkau.taller.vendedor.value.VendedorId;

public class AgregarCliente extends Command {
    private final ClienteId clienteId;
    private final Documento documento;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;

    public AgregarCliente(ClienteId clienteId, Documento documento,
                          Nombre nombre, Telefono telefono, Correo correo) {
        this.clienteId = clienteId;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public ClienteId getClienteId() {
        return clienteId;
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
