package co.com.sofkau.taller.mecanico.value;

import co.com.sofka.domain.generic.Identity;

public class InspeccionId extends Identity {

    public InspeccionId(String id) {
        super(id);
    }

    public InspeccionId() {
    }

    public static InspeccionId of(String id) {
        return new InspeccionId(id);
    }
}
