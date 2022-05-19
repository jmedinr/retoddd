package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.asesor.value.AutorizacionCliente;
import co.com.sofkau.taller.asesor.value.Ingreso;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.asesor.value.TipoRegistro;
import co.com.sofkau.taller.mecanico.value.MecanicoId;


public class RegistroExitoso extends DomainEvent {
    private final RegistroId registroId;
    private final MecanicoId mecanicoId;
    private final TipoRegistro tipoRegistro;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;


    public RegistroExitoso(RegistroId registroId, MecanicoId mecanicoId, TipoRegistro tipoRegistro, Ingreso ingreso, AutorizacionCliente autorizacionCliente) {
        super("co.com.sofkau.taller.RegistroExistoso");
        this.registroId = registroId;
        this.mecanicoId = mecanicoId;
        this.tipoRegistro = tipoRegistro;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
    }

    public RegistroId getRegistroId() {
        return registroId;
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
}
