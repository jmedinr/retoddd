package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.Identity;

public class EntregaId extends Identity {

    public EntregaId(String id){
        super(id);
    }

    public EntregaId() {
    }

    public static EntregaId of(String id) {
        return new EntregaId(id);
    }
}
