package co.com.sofkau.taller.mecanico.value;

import co.com.sofka.domain.generic.Identity;

public class ReparacionId extends Identity {
    public ReparacionId(String id) {
        super(id);
    }

    public ReparacionId() {
    }

    public static ReparacionId of(String id) {
        return new ReparacionId(id);
    }
}
