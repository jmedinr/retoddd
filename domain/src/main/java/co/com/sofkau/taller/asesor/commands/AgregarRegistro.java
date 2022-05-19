package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.Map;

public class AgregarRegistro extends Command {
    private final RegistroId registroId;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;
    private final TipoRegistro tipoRegistro;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;
    private final Map<AutoId, Auto> autoMap;
    private final Map<ClienteId, Cliente> clienteMap;



    public AgregarRegistro(RegistroId registroId, MecanicoId mecanicoId, VendedorId vendedorId, TipoRegistro tipoRegistro,
                           Ingreso ingreso, AutorizacionCliente autorizacionCliente, Map<AutoId, Auto> autoMap, Map<ClienteId, Cliente> clienteMap) {
        this.registroId = registroId;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
        this.tipoRegistro = tipoRegistro;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.autoMap = autoMap;
        this.clienteMap = clienteMap;
    }

    public RegistroId getRegistroId() {
        return registroId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Map<ClienteId, Cliente> getClienteMap() {
        return clienteMap;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
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
