package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.value.*;

import java.util.Set;

/**
 * Entidad que representa una factura del negocio
 */
public class Factura extends Entity<FacturaId> {
    protected VendedorId vendedorId;
    protected DatosCliente datosCliente;
    protected Set<DatosEmpresa> datosEmpresa;
    protected Set<DatosAuto> datosAuto;
    protected Set<ListaRepuestos> listaRepuestosSet;
    protected ValorCompra valorCompra;
    protected ValorReparacion valorReparacion;
    protected ValorTotal valorTotal;

    public Factura(FacturaId entityId, VendedorId vendedorId,
                   DatosCliente datosCliente, Set<DatosEmpresa> datosEmpresa,
                   Set<DatosAuto> datosAuto, Set<ListaRepuestos> listaRepuestosSet,
                   ValorCompra valorCompra, ValorReparacion valorReparacion, ValorTotal valorTotal) {
        super(entityId);
        this.vendedorId = vendedorId;
        this.datosCliente = datosCliente;
        this.datosEmpresa = datosEmpresa;
        this.datosAuto = datosAuto;
        this.listaRepuestosSet = listaRepuestosSet;
        this.valorCompra = valorCompra;
        this.valorReparacion = valorReparacion;
        this.valorTotal = valorTotal;
    }


    public VendedorId getVendedorId() {
        return vendedorId;
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
