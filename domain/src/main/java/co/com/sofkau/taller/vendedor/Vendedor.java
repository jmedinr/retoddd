package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Correo;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Telefono;
import co.com.sofkau.taller.asesor.Auto;
import co.com.sofkau.taller.asesor.Cliente;
import co.com.sofkau.taller.mecanico.value.ListaRepuestos;
import co.com.sofkau.taller.vendedor.events.*;
import co.com.sofkau.taller.vendedor.value.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vendedor extends AggregateEvent<VendedorId> {
    protected Nombre nombre;
    protected Telefono telefono;
    protected Correo correo;
    protected Map<CompraId, Compra> compra;
    protected Map<VentaId, Venta> venta;
    protected Map<EntregaId, Entrega> entrega;
    protected Map<FacturaId, Factura> factura;
    protected Set<Cliente> clienteSet;
    protected Set<Auto> autoSet;
    protected Set<ListaRepuestos> listaRepuestosSet;

    public Vendedor(VendedorId entityId, Nombre nombre, Telefono telefono, Correo correo,
                    Set<Cliente> clienteSet, Set<Auto> autoSet, Set<ListaRepuestos> listaRepuestosSet) {
        super(entityId);
        appendChange(new VendedorAsignado(entityId, nombre, telefono, correo, clienteSet, autoSet, listaRepuestosSet));
        subscribe(new VendedorEventChange(this));
    }

    private Vendedor(VendedorId entityId) {
        super(entityId);
        subscribe(new VendedorEventChange(this));
    }

    public static Vendedor from(VendedorId entityId, List<DomainEvent> events) {
        var vendedor = new Vendedor(entityId);
        events.forEach(vendedor::applyEvent);
        return vendedor;
    }

    public void crearCompra(VendedorId vendedorId, ValorCompra compra) {
        appendChange(new CompraGenerada(vendedorId, compra)).apply();
    }

    public void crearVenta(VendedorId vendedorId, TipoPago tipoPago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        appendChange(new VentaGenerada(vendedorId, tipoPago, metodoPago, valorReparacion)).apply();
    }

    public void crearEntrega(VendedorId vendedorId, Salida salida, ValorTotal valorTotal) {
        appendChange(new EntregaRealizada(vendedorId, salida, valorTotal)).apply();
    }

    public void crearFactura(FacturaId facturaId, VendedorId vendedorId, DatosCliente datosCliente,
                             Set<DatosEmpresa> datosEmpresa, Set<DatosAuto> datosAuto,
                             Set<ListaRepuestos> listaRepuestosSet, ValorCompra valorCompra,
                             ValorReparacion valorReparacion, ValorTotal valorTotal) {
        appendChange(new FacturaGenerada(facturaId,vendedorId,datosCliente,datosEmpresa,datosAuto,
                listaRepuestosSet,valorCompra,valorReparacion,valorTotal)).apply();


    }
}
