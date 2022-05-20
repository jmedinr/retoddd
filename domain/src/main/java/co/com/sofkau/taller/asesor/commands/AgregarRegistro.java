package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.value.*;

public class AgregarRegistro extends Command {
    private final RegistroId registroId;
    private final AsesorId asesorId;
    private final ClienteId clienteId;
    private final AutoId autoId;
    private final TipoTrabajo tipoTrabajo;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;

    public AgregarRegistro(RegistroId registroId, AsesorId asesorId, ClienteId clienteId, AutoId autoId,
                           TipoTrabajo tipoTrabajo, Ingreso ingreso, AutorizacionCliente autorizacionCliente) {
        this.registroId = registroId;
        this.asesorId = asesorId;
        this.clienteId = clienteId;
        this.autoId = autoId;
        this.tipoTrabajo = tipoTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public AutorizacionCliente getAutorizacionCliente() {
        return autorizacionCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public AutoId getAutoId() {
        return autoId;
    }
}
