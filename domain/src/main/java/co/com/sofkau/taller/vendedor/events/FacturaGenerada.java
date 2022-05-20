package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.value.*;

import java.util.Set;

public class FacturaGenerada extends DomainEvent {
    private final DatosCliente datosCliente;
    private final Set<DatosEmpresa> datosEmpresa;
    private final Set<DatosAuto> datosAuto;
    private final Set<ListaRepuestos> listaRepuestosSet;
    private final ValorCompra valorCompra;
    private final ValorReparacion valorReparacion;
    private final ValorTotal valorTotal;

    public FacturaGenerada(DatosCliente datosCliente, Set<DatosEmpresa> datosEmpresa, Set<DatosAuto> datosAuto,
                           Set<ListaRepuestos> listaRepuestosSet, ValorCompra valorCompra,
                           ValorReparacion valorReparacion, ValorTotal valorTotal) {
        super("co.com.sofkau.taller.FacturaGenerada");
        this.datosCliente = datosCliente;
        this.datosEmpresa = datosEmpresa;
        this.datosAuto = datosAuto;
        this.listaRepuestosSet = listaRepuestosSet;
        this.valorCompra = valorCompra;
        this.valorReparacion = valorReparacion;
        this.valorTotal = valorTotal;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public Set<DatosEmpresa> getDatosEmpresa() {
        return datosEmpresa;
    }

    public Set<DatosAuto> getDatosAuto() {
        return datosAuto;
    }

    public Set<ListaRepuestos> getListaRepuestosSet() {
        return listaRepuestosSet;
    }

    public ValorCompra getValorCompra() {
        return valorCompra;
    }

    public ValorReparacion getValorReparacion() {
        return valorReparacion;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
