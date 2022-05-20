package co.com.sofkau.taller.asesor.value;

import co.com.sofka.domain.generic.Identity;

public class RegistroId extends Identity {
    public RegistroId(String id) {
        super(id);
    }

    public RegistroId() {
    }

    public static RegistroId of(String id) {
        return new RegistroId(id);
    }
}
