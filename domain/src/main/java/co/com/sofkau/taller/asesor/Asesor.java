package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.events.AsesorAgregado;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.ClienteId;
import co.com.sofkau.taller.asesor.value.RegistroId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

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
        appendChange(new AsesorAgregado(nombre, telefono, correo, mecanicoId, vendedorId)).apply();
        subscribe(new AsesorEventChange(this));
    }
}
