package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.taller.asesor.events.AsesorAgregado;

import java.util.HashMap;

public class AsesorEventChange extends EventChange {
    public AsesorEventChange(Asesor asesor) {
        apply((AsesorAgregado event) ->{
            asesor.nombre = event.getNombre();
            asesor.telefono = event.getTelefono();
            asesor.correo = event.getCorreo();
            asesor.mecanicoId = event.getMecanicoId();
            asesor.vendedorId = event.getVendedorId();
            asesor.autoMap = new HashMap<>();
            asesor.clienteMap = new HashMap<>();
            asesor.registroMap = new HashMap<>();
        });
    }
}
