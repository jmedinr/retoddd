package co.com.sofkau.taller.vendedor.factory;

import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.Factura;
import co.com.sofkau.taller.vendedor.value.*;

import java.util.HashSet;
import java.util.Set;

public class FacturaFactory {
    private final Set<Factura> factura;

    public FacturaFactory() {
        factura = new HashSet<>();
    }

    public static FacturaFactory builder() {
        return new FacturaFactory();
    }

    public FacturaFactory agregarFactura(FacturaId entityId, DatosCliente datosCliente,
                                         Set<DatosEmpresa> datosEmpresa,
                                         Set<DatosAuto> datosAuto, Set<ListaRepuestos> listaRepuestosSet,
                                         ValorCompra valorCompra, ValorReparacion valorReparacion,
                                         ValorTotal valorTotal) {
        factura.add(new Factura(entityId, datosCliente, datosEmpresa, datosAuto,
                listaRepuestosSet, valorCompra, valorReparacion, valorTotal));
        return this;
    }

    public Set<Factura> factura() {
        return factura;
    }
}
