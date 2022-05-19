package co.com.sofkau.taller.mecanico.value;

import co.com.sofka.domain.generic.Identity;

public class MecanicoId extends Identity {
    public MecanicoId(String id){
        super(id);
    }
    public static MecanicoId of(String id) {
        return new MecanicoId(id);
    }
}
