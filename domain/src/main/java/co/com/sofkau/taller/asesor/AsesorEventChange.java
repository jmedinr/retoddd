package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.asesor.events.AsesorAsignado;
import co.com.sofkau.taller.asesor.events.AutoAgregado;
import co.com.sofkau.taller.asesor.events.ClienteAgregado;
import co.com.sofkau.taller.asesor.events.RegistroExitoso;

import java.util.HashMap;

/**
 * Controlador de eventos para el agregado asesor
 */
public class AsesorEventChange extends EventChange {
    public AsesorEventChange(Asesor asesor) {
        apply((AsesorAsignado event) -> {
            asesor.nombre = event.getNombre();
            asesor.telefono = event.getTelefono();
            asesor.correo = event.getCorreo();
            asesor.mecanicoId = event.getMecanicoId();
            asesor.vendedorId = event.getVendedorId();
            asesor.autoMap = new HashMap<>();
            asesor.clienteMap = new HashMap<>();
            asesor.registroMap = new HashMap<>();
        });

        apply((AutoAgregado event) -> {
            var autoId = event.getAutoId();
            var auto = new Auto(autoId, event.getMarca(), event.getPlaca());
            asesor.autoMap.put(autoId, auto);
        });

        apply((ClienteAgregado event) -> {
            var clienteId = event.getClienteId();
            var cliente = new Cliente(clienteId, event.getDocumento(), event.getNombre(),
                    event.getTelefono(), event.getCorreo());
            asesor.clienteMap.put(clienteId, cliente);
        });

        apply((RegistroExitoso event) -> {
            var registroId = event.getRegistroId();
            var registro = new Registro(registroId, event.getTipoTrabajo(), event.getIngreso(),
                    event.getAutorizacionCliente(), event.getClienteMap(), event.getAutoMap());
            asesor.registroMap.put(registroId, registro);
        });
    }
}
