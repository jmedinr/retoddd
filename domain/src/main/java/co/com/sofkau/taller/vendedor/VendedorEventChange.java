package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.vendedor.events.*;
import co.com.sofkau.taller.vendedor.value.CompraId;
import co.com.sofkau.taller.vendedor.value.EntregaId;
import co.com.sofkau.taller.vendedor.value.FacturaId;
import co.com.sofkau.taller.vendedor.value.VentaId;

import java.util.HashMap;

public class VendedorEventChange extends EventChange {
    public VendedorEventChange(Vendedor vendedor) {
        apply((VendedorAsignado event) -> {
            vendedor.nombre = event.getNombre();
            vendedor.telefono = event.getTelefono();
            vendedor.correo = event.getCorreo();
            vendedor.listaRepuestosSet = event.getListaRepuestosSet();
            vendedor.clienteSet = event.getClienteSet();
            vendedor.autoSet = event.getAutoSet();
            vendedor.venta = new HashMap<>();
            vendedor.compra = new HashMap<>();
            vendedor.entrega = new HashMap<>();
            vendedor.factura = new HashMap<>();
        });

        apply((VentaGenerada event) -> {
            var ventaId = new VentaId();
            var venta = new Venta(ventaId, event.getTipoPago(), event.getMetodoPago(), event.getValorReparacion());
            vendedor.venta.put(ventaId, venta);
        });

        apply((CompraGenerada event) -> {
            var compraId = new CompraId();
            var compra = new Compra(compraId, event.getValorCompra());
            vendedor.compra.put(compraId, compra);
        });

        apply((EntregaRealizada event) -> {
            var entregaId = new EntregaId();
            var entrega = new Entrega(entregaId, event.getSalida(), event.getValorTotal());
            vendedor.entrega.put(entregaId, entrega);
        });

        apply((FacturaGenerada event) -> {
            var facturaId = new FacturaId();
            var factura = new Factura(facturaId, event.getVendedorId(), event.getDatosCliente(),
                    event.getDatosEmpresa(), event.getDatosAuto(), event.getListaRepuestosSet(), event.getValorCompra(),
                    event.getValorReparacion(), event.getValorTotal());
            vendedor.factura.put(facturaId, factura);
        });
    }
}
