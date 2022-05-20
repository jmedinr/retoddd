package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.Documento;

public class AgregarCliente extends Command {
    private final ClienteId clienteId;
    private final AsesorId asesorId;
    private final Documento documento;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;

    public AgregarCliente(ClienteId clienteId, AsesorId asesorId, Documento documento,
                          Nombre nombre, Telefono telefono, Correo correo) {
        this.clienteId = clienteId;
        this.asesorId = asesorId;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public AsesorId getAsesorId() {
        return asesorId;
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
