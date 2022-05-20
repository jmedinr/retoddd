package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.value.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class FacturaGenerada extends DomainEvent {
    private final List<TuplaFactura> tuplaFacturas;
    private final VendedorId vendedorId;

    public FacturaGenerada(List<TuplaFactura> tuplaFacturas, VendedorId vendedorId) {
        super("co.com.sofkau.taller.FacrturaGenerada");
        this.tuplaFacturas = tuplaFacturas;
        this.vendedorId = vendedorId;
    }

    public List<TuplaFactura> getTuplaFacturas() {
        return tuplaFacturas;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public static class TuplaFactura implements Serializable {
        private FacturaId facturaId;
        private DatosCliente datosCliente;
        private Set<DatosEmpresa> datosEmpresa;
        private Set<DatosAuto> datosAuto;
        private Set<ListaRepuestos> listaRepuestosSet;
        private ValorCompra valorCompra;
        private ValorReparacion valorReparacion;
        private ValorTotal valorTotal;

        public TuplaFactura(FacturaId facturaId, DatosCliente datosCliente, Set<DatosEmpresa> datosEmpresa,
                            Set<DatosAuto> datosAuto, Set<ListaRepuestos> listaRepuestosSet,
                            ValorCompra valorCompra, ValorReparacion valorReparacion, ValorTotal valorTotal) {
            this.facturaId = facturaId;
            this.datosCliente = datosCliente;
            this.datosEmpresa = datosEmpresa;
            this.datosAuto = datosAuto;
            this.listaRepuestosSet = listaRepuestosSet;
            this.valorCompra = valorCompra;
            this.valorReparacion = valorReparacion;
            this.valorTotal = valorTotal;
        }

        public TuplaFactura() {

        }

        public FacturaId getFacturaId() {
            return facturaId;
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
}
