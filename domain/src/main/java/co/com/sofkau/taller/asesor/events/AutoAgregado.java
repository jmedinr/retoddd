package co.com.sofkau.taller.asesor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.asesor.value.AutoId;
import co.com.sofkau.taller.asesor.value.Marca;
import co.com.sofkau.taller.asesor.value.Placa;
import co.com.sofkau.taller.mecanico.value.MecanicoId;
import co.com.sofkau.taller.vendedor.value.VendedorId;

public class AutoAgregado extends DomainEvent {
    private final AutoId autoId;
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final Marca marca;
    private final Placa placa;


    public AutoAgregado(AutoId autoId, VendedorId vendedorId, MecanicoId mecanicoId, Marca marca, Placa placa) {
        super("co.com.sofkau.taller.AutoAgregado");
        this.autoId = autoId;
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.marca = marca;
        this.placa = placa;
    }

    public AutoId getAutoId() {
        return autoId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Placa getPlaca() {
        return placa;
    }
}
