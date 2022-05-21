package co.com.sofkau.taller.asesor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.Marca;
import co.com.sofkau.taller.asesor.value.Placa;

/**
 * Entidad automovil que será reparado
 */
public class Auto extends Entity<AutoId> {
    protected Marca marca;
    protected Placa placa;

    public Auto(AutoId entityId, Marca marca, Placa placa) {
        super(entityId);
        this.marca = marca;
        this.placa = placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }
}
