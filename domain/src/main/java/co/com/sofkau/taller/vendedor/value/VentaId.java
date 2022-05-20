package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.Identity;

public class VentaId extends Identity {
    public VentaId(String id){
        super(id);
    }

    public VentaId() {
    }

    public static VentaId of(String id) {
        return new VentaId(id);
    }
}
