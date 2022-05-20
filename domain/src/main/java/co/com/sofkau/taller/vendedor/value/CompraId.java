package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.taller.asesor.value.AsesorId;

public class CompraId extends Identity {
    public CompraId(String id){
        super(id);
    }

    public CompraId() {
    }

    public static CompraId of(String id) {
        return new CompraId(id);
    }
}
