package co.com.sofkau.taller.vendedor.value;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
    public FacturaId(String id){
        super(id);
    }

    public FacturaId() {
    }

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
