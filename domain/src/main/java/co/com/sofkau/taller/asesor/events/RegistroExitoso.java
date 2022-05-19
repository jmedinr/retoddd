package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.TipoTrabajo;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;


public class RegistroExitoso extends DomainEvent {
    private final RegistroId registroId;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;
    private final TipoTrabajo tipoTrabajo;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;
    private final Map<ClienteId, Cliente> clienteMap;
    private final Map<AutoId, Auto> autoMap;

    public RegistroExitoso(RegistroId registroId, MecanicoId mecanicoId, VendedorId vendedorId,
                           TipoTrabajo tipoTrabajo, Ingreso ingreso, AutorizacionCliente autorizacionCliente,
                           Map<ClienteId, Cliente> clienteMap, Map<AutoId, Auto> autoMap) {
        super("co.com.sofkau.taller.RegistroExitoso");
        this.registroId = registroId;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
        this.tipoTrabajo = tipoTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.clienteMap = clienteMap;
        this.autoMap = autoMap;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public AutorizacionCliente getAutorizacionCliente() {
        return autorizacionCliente;
    }

    public Map<ClienteId, Cliente> getClienteMap() {
        return clienteMap;
    }

    public Map<AutoId, Auto> getAutoMap() {
        return autoMap;
    }
}
