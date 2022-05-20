package co.com.sofkau.taller.asesor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.asesor.value.AsesorId;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.Marca;
import co.com.sofkau.taller.asesor.value.Placa;

public class AgregarAuto extends Command {
    private final AutoId autoId;
    private final AsesorId asesorId;
    private final Marca marca;
    private final Placa placa;


    public AgregarAuto(AutoId autoId, AsesorId asesorId, Marca marca, Placa placa) {
        this.autoId = autoId;
        this.asesorId = asesorId;
        this.marca = marca;
        this.placa = placa;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public AutoId getAutoId() {
        return autoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Placa getPlaca() {
        return placa;
    }
}
