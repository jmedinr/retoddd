package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.Documento;

/**
 * Entidad cliente que quiere que le reparen un auto
 */
public class Cliente extends Entity<ClienteId> {
    protected Documento documento;
    protected Nombre nombre;
    protected Telefono telefono;
    protected Correo correo;

    public Cliente(ClienteId entityId, Documento documento, Nombre nombre, Telefono telefono, Correo correo) {
        super(entityId);
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
}
