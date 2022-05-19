package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.events.AutoAgregado;
import co.com.sofkau.taller.asesor.events.ClienteAgregado;
import co.com.sofkau.taller.asesor.events.RegistroExitoso;
import co.com.sofkau.taller.asesor.value.*;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

import java.util.List;
import java.util.Map;

public class Asesor extends AggregateEvent<AsesorId> {
    protected MecanicoId mecanicoId;
    protected VendedorId vendedorId;
    protected Nombre nombre;
    protected Correo correo;
    protected Telefono telefono;
    protected Map<RegistroId, Registro> registroMap;
    protected Map<ClienteId, Cliente> clienteMap;
    protected Map<AutoId, Auto> autoMap;

    public Asesor(AsesorId entityId, MecanicoId mecanicoId, VendedorId vendedorId, Nombre nombre,
                  Correo correo, Telefono telefono) {
        super(entityId);
        appendChange(new AsesorAsignado(nombre, telefono, correo, mecanicoId, vendedorId)).apply();
        subscribe(new AsesorEventChange(this));
    }

    private Asesor(AsesorId entityId){
        super(entityId);
        subscribe(new AsesorEventChange(this));
    }

    public static Asesor from(AsesorId entityId, List<DomainEvent> events){
        var curso = new Asesor(entityId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarRegistro( TipoRegistro tipoRegistro, Ingreso ingreso, AutorizacionCliente autorizacionCliente){
        var registroId = new RegistroId();
        appendChange(new RegistroExitoso(registroId, this.mecanicoId, tipoRegistro, ingreso,autorizacionCliente)).apply();
    }

    public void agregarCliente( Documento documento, Nombre nombre, Telefono telefono, Correo correo){
        var clienteId = new ClienteId();
        appendChange(new ClienteAgregado(clienteId,this.vendedorId,documento,nombre,telefono,correo)).apply();
    }

    public void agregarAuto( Marca marca, Placa placa){
        var autoId = new AutoId();
        appendChange(new AutoAgregado(autoId,this.vendedorId, this.mecanicoId,marca,placa)).apply();
    }

    public MecanicoId mecanicoId() {
        return this.mecanicoId;
    }

    public VendedorId vendedorId() {
        return this.vendedorId;
    }

    public Nombre nombre() {
        return this.nombre;
    }

    public Correo correo() {
        return this.correo;
    }

    public Telefono telefono() {
        return this.telefono;
    }

    public Map<RegistroId, Registro> registroMap() {
        return this.registroMap;
    }

    public Map<ClienteId, Cliente> clienteMap() {
        return this.clienteMap;
    }

    public Map<AutoId, Auto> autoMap() {
        return this.autoMap;
    }
}
