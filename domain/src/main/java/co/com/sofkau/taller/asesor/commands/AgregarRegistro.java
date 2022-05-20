package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class AgregarRegistro extends Command {
    private final RegistroId registroId;
    private final AsesorId asesorId;
    private final TipoTrabajo tipoTrabajo;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;
    private final Map<AutoId, Auto> autoMap;
    private final Map<ClienteId, Cliente> clienteMap;


    public AgregarRegistro(RegistroId registroId, MecanicoId mecanicoId, VendedorId vendedorId, AsesorId asesorId, TipoTrabajo tipoTrabajo,
                           Ingreso ingreso, AutorizacionCliente autorizacionCliente,
                           Map<AutoId, Auto> autoMap, Map<ClienteId, Cliente> clienteMap) {
        this.registroId = registroId;
        this.asesorId = asesorId;
        this.tipoTrabajo = tipoTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.autoMap = autoMap;
        this.clienteMap = clienteMap;
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

    public Map<ClienteId, Cliente> getClienteMap() {
        return clienteMap;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public AutorizacionCliente getAutorizacionCliente() {
        return autorizacionCliente;
    }

    public Map<AutoId, Auto> getAutoMap() {
        return autoMap;
    }
}
