package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.asesor.value.AutorizacionCliente;
import co.com.sofkau.taller.asesor.value.Ingreso;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.asesor.value.TipoRegistro;

public class Registro extends Entity<RegistroId> {
    protected TipoRegistro tipoRegistro;
    protected Ingreso ingreso;
    protected AutorizacionCliente autorizacionCliente;


    public Registro(RegistroId entityId, TipoRegistro tipoRegistro, Ingreso ingreso, AutorizacionCliente autorizacionCliente) {
        super(entityId);
        this.tipoRegistro = tipoRegistro;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
    }


    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
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
}
