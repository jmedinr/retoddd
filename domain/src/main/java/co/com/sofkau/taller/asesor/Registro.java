package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.generic.values.TipoTrabajo;

import java.util.Map;

public class Registro extends Entity<RegistroId> {
    protected TipoTrabajo tipoTrabajo;
    protected Ingreso ingreso;
    protected AutorizacionCliente autorizacionCliente;
    protected Map<ClienteId, Cliente> clienteMap;
    protected Map<AutoId, Auto> autoMap;


    public Registro(RegistroId entityId, TipoTrabajo tipoTrabajo, Ingreso ingreso,
                    AutorizacionCliente autorizacionCliente,
                    Map<ClienteId, Cliente> clienteMap, Map<AutoId, Auto> autoMap) {
        super(entityId);
        this.tipoTrabajo = tipoTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.clienteMap = clienteMap;
        this.autoMap = autoMap;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public AutorizacionCliente getAutorizacionCliente() {
        return autorizacionCliente;
    }

    public void setAutorizacionCliente(AutorizacionCliente autorizacionCliente) {
        this.autorizacionCliente = autorizacionCliente;
    }

    public Map<ClienteId, Cliente> getClienteMap() {
        return clienteMap;
    }

    public void setClienteMap(Map<ClienteId, Cliente> clienteMap) {
        this.clienteMap = clienteMap;
    }

    public Map<AutoId, Auto> getAutoMap() {
        return autoMap;
    }

    public void setAutoMap(Map<AutoId, Auto> autoMap) {
        this.autoMap = autoMap;
    }
}
