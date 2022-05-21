package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

/**
 * Esta clase es un comando para regitrar un asesor y asociarlo con un mecanico y un vendedor
 */
public class AsignarAsesor extends Command {
    private final AsesorId asesorId;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Correo correo;
    private final Telefono telefono;

    public AsignarAsesor(AsesorId asesorId, MecanicoId mecanicoId, VendedorId vendedorId,
                         Nombre nombre, Correo correo, Telefono telefono) {
        this.asesorId = asesorId;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Correo getCorreo() {
        return correo;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
