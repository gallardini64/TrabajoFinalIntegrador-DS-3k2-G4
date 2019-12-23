/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dominio.*;
import datos.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.*;


/**
 *
 * @author luciano
 */
public class ControladorCrearPedido implements ActionListener{
    private SeleccionarTipoPedido vistaTipoPedido;
    private CrearPedidos vistaCrearPedido;
    private AgregarUbicacion vistaAgregarUbicacion;
    private PedidoDelivery vistaDelivery;
    private PedidoEncargo vistaEncargo;
    private PedidoConsumoPersonal vistaConsumoPersonal;
    private Pedido pedido;
    private Repositorio repositorio;
    private Sucursal sucursal;
    private IDatosPedido vista;
    
    
    
    public ControladorCrearPedido() {
    vistaTipoPedido = new SeleccionarTipoPedido();
    repositorio = Repositorio.getInstance();
    sucursal = new Sucursal();
    sucursal.inicializar();
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Eventos Vista Seleccionar Tipo
        
        if(e.getActionCommand().equals(vistaTipoPedido.TIPO_LOCAL)){
            vistaCrearPedido = new CrearPedidos();
            vistaCrearPedido.ejecutar();
            vistaCrearPedido.setControlador(this);
            pedido = new Local();
            this.inicializarVistaCrearPedidos();
            
        }
        
        if(e.getActionCommand().equals(vistaTipoPedido.TIPO_DELIVERY)){
            vistaCrearPedido = new CrearPedidos();
            vistaCrearPedido.ejecutar();
            vistaCrearPedido.setControlador(this);
            pedido = new Delivery();
            this.inicializarVistaCrearPedidos();
        }
        
        if(e.getActionCommand().equals(vistaTipoPedido.TIPO_ENCARGO)){
            vistaCrearPedido = new CrearPedidos();
            vistaCrearPedido.ejecutar();
            vistaCrearPedido.setControlador(this);
            pedido = new Encargo();
            this.inicializarVistaCrearPedidos();
        }
        
        if(e.getActionCommand().equals(vistaTipoPedido.TIPO_CONSUMO_PERSONAL)){
            vistaCrearPedido = new CrearPedidos();
            vistaCrearPedido.ejecutar();
            vistaCrearPedido.setControlador(this);
            pedido = new ConsumoPersonal();
            this.inicializarVistaCrearPedidos();
        }
            
        //Eventos Vista Crear Pedido
        
        if(e.getActionCommand().equals(vistaCrearPedido.BOTON_AGREGAR_EMPANADA)){
           Empanada empanada = repositorio.getEmpanda(vistaCrearPedido.getEmpanada());
           if(vistaCrearPedido.getCantidad() != 0){
                
                if(sucursal.obtenerStock(empanada.getRelleno()) - vistaCrearPedido.getCantidad() >= 0){
                    pedido.agregarLineaPedido(empanada,vistaCrearPedido.getCantidad());
                    String linea[] = new String[4];
                    linea[0] = "Empandada de "+vistaCrearPedido.getEmpanada();
                    linea[1] = ""+vistaCrearPedido.getCantidad();
                    linea[2] = ""+pedido.obtenerUltimaLineaPedido().getSubtotal();
                    linea[3] = "Ahorra "+this.calcularDescuento(vistaCrearPedido.getCantidad())+" Empanadas";
                    vistaCrearPedido.agregarFila(linea);
                    vistaCrearPedido.setCampoTotal(vistaCrearPedido.getCampoTotal() + pedido.obtenerUltimaLineaPedido().getSubtotal());
                }else{
                        if((pedido)instanceof Encargo){
                            pedido.agregarLineaPedido(empanada,vistaCrearPedido.getCantidad());
                            String linea[] = new String[4];
                            linea[0] = "Empandada de "+vistaCrearPedido.getEmpanada();
                            linea[1] = ""+vistaCrearPedido.getCantidad();
                            linea[2] = ""+pedido.obtenerUltimaLineaPedido().getSubtotal();
                            linea[3] = "Ahorra "+this.calcularDescuento(vistaCrearPedido.getCantidad())+" Empanadas";
                            vistaCrearPedido.agregarFila(linea);
                            vistaCrearPedido.setCampoTotal(vistaCrearPedido.getCampoTotal() + pedido.obtenerUltimaLineaPedido().getSubtotal());
                        }else{
                        JOptionPane.showMessageDialog(null, "no hay stock suficiente de empanadas de " + empanada.getRelleno());
                        JOptionPane.showMessageDialog(null, "el stock es de" + sucursal.obtenerStock(vistaCrearPedido.getEmpanada()));    
                        }                    

                }
           }else JOptionPane.showMessageDialog(null, "ingrese una cantidad por favor");
        }
        
        if(e.getActionCommand().equals(vistaCrearPedido.BOTON_AGREGAR_BEBIDA)){
           Bebida beb = new Bebida(Double.parseDouble(vistaCrearPedido.getVolumen()), vistaCrearPedido.getBebida());
           Bebida bebida = repositorio.getBebida(beb);
           if(sucursal.obtenerStock(bebida) > 0){
           pedido.agregarLineaPedido(bebida);
           String linea[] = new String[4];
           linea[0] = "" + vistaCrearPedido.getBebida();
           linea[1] = ""+this.convertirVolumen(vistaCrearPedido.getVolumen());
           linea[2] = ""+pedido.obtenerUltimaLineaPedido().getSubtotal();
           linea[3] = " ";
           vistaCrearPedido.agregarFila(linea);
           vistaCrearPedido.setCampoTotal(vistaCrearPedido.getCampoTotal() + pedido.obtenerUltimaLineaPedido().getSubtotal());
        }else 
           if ((pedido)instanceof Encargo){
                      pedido.agregarLineaPedido(bebida);
           String linea[] = new String[4];
           linea[0] = "" + vistaCrearPedido.getBebida();
           linea[1] = ""+this.convertirVolumen(vistaCrearPedido.getVolumen());
           linea[2] = ""+pedido.obtenerUltimaLineaPedido().getSubtotal();
           linea[3] = " ";
           vistaCrearPedido.agregarFila(linea);
           vistaCrearPedido.setCampoTotal(vistaCrearPedido.getCampoTotal() + pedido.obtenerUltimaLineaPedido().getSubtotal());
               
        }else JOptionPane.showMessageDialog(null, "no hay " + vistaCrearPedido.getBebida() + " de " + this.convertirVolumen(vistaCrearPedido.getVolumen()));
        }
        
        if(e.getActionCommand().equals(vistaCrearPedido.BOTON_QUITAR_PRODUCTO)){
            int fila = vistaCrearPedido.obtenerFilaSeleccionada();
            if(fila >= 0){
                pedido.eliminarLineaPedido(fila);
                vistaCrearPedido.setCampoTotal(vistaCrearPedido.getCampoTotal() - vistaCrearPedido.obtenerSubtotal(fila));
                vistaCrearPedido.eliminarFilaSeleccionada(fila);
                
            }else{
                JOptionPane.showMessageDialog(null, "no agrego nada aun o no selecciono nada");
            }
        }
        
        if(e.getActionCommand().equals(vistaCrearPedido.BOTON_FINALIZAR_DETALLE)){
           if(pedido.getDetallePedido().size() > 0){
                pedido.finalizar(repositorio.obtenerNuenoNumeroPedido());
                pedido.setTotal(vistaCrearPedido.getCampoTotal());
                repositorio.agregarPedido(pedido);
                vista = this.agregarDatosExtra();
                if(vista == null){
                vistaAgregarUbicacion = new AgregarUbicacion();
                vistaAgregarUbicacion.ejecutar();
                this.cargarDetalleEnUbicaciones(pedido);
                vistaAgregarUbicacion.setControlador(this);
                }else{
                vista.ejecutar();
                vista.setControlador(this);
                }
           }else JOptionPane.showMessageDialog(null, "no agrego nada al pedido");
        }
        
        if(e.getActionCommand().equals(vistaDelivery.BOTON_ACEPTAR_DELIVERY)){
            Delivery d = new Delivery();
            d.setDetallePedido(pedido.getDetallePedido());
            d.setTotal(pedido.getTotal());
            vistaDelivery = (PedidoDelivery) vista;
            if(!"".equals(vistaDelivery.getCampoDireccionEntrega()))d.setDireccionEntrega(vistaDelivery.getCampoDireccionEntrega());
            else JOptionPane.showMessageDialog(null, "ingrese una direccion de entrega");
            if(!"".equals(vistaDelivery.getCampoNombreFamili()))d.setNombreFamilia(vistaDelivery.getCampoNombreFamili());
            else JOptionPane.showMessageDialog(null, "ingrese un nombre de familia");
            if(vistaDelivery.getCampoDireccionEntrega() != "" && vistaDelivery.getCampoNombreFamili() != ""){
                d.setEstado(Estado.PENDIENTE);
                repositorio.agregarPedido(d);
                vistaAgregarUbicacion = new AgregarUbicacion();
                vistaAgregarUbicacion.ejecutar();
                this.cargarDetalleEnUbicaciones(pedido);
                vistaAgregarUbicacion.setControlador(this);
            }else JOptionPane.showMessageDialog(null, "no deje ningun campo vacio");
        }
        
        if(e.getActionCommand().equals(vistaEncargo.BOTON_ACEPTAR_ENCARGO)){
            Encargo encargo = new Encargo();
            encargo.setDetallePedido(pedido.getDetallePedido());
            encargo.setTotal(pedido.getTotal());
            vistaEncargo = (PedidoEncargo) vista;
            if(vistaEncargo.verificar()){
                encargo.setDireccionDeEntrega(vistaEncargo.getCampoDireccionEntrega());
                encargo.setFechaDeEntrega(vistaEncargo.getCampoFechaEntrega());
                Cliente cli = new Cliente();
                cli.setNombre(vistaEncargo.getCampoNombreCliente());
                cli.setDireccion(vistaEncargo.getCampoDireccionCliente());
                cli.setTelefono(vistaEncargo.getCampoTelefonoCliente());
                encargo.setCliente(cli);
                encargo.setEstado(Estado.PENDIENTE);
                repositorio.agregarPedido(encargo);
                JOptionPane.showMessageDialog(null, "pedido finalizado");
            }else JOptionPane.showMessageDialog(null, "no deje ningun campo vacio");
        }
        
        if(e.getActionCommand().equals(vistaConsumoPersonal.BOTON_ACEPTAR_CONSUMO_PERSONAL)){
            ConsumoPersonal consumo = new ConsumoPersonal();
            consumo.setDetallePedido(pedido.getDetallePedido());
            consumo.setTotal(pedido.getTotal());
            vistaConsumoPersonal = (PedidoConsumoPersonal) vista;
            if(vistaConsumoPersonal.verificar()){
                consumo.setDescripcion(vistaConsumoPersonal.getCampoDescripcion());
                consumo.setEstado(Estado.PENDIENTE);
                repositorio.agregarPedido(consumo);
                vistaAgregarUbicacion = new AgregarUbicacion();
                vistaAgregarUbicacion.ejecutar();
                this.cargarDetalleEnUbicaciones(pedido);
                vistaAgregarUbicacion.setControlador(this);
            }else JOptionPane.showMessageDialog(null, "no deje ningun campo vacio");
            
        }
        
        if(e.getActionCommand().equals(vistaAgregarUbicacion.BOTON_SELECCIONAR)){

            int fila = vistaAgregarUbicacion.obtenerFilaSeleccionada();
            if(fila >= 0){
               vistaAgregarUbicacion.activarBotones();
               if((pedido.getDetallePedido().get(fila).getProducto())instanceof Empanada){
                    ArrayList<Bandeja> bandejas = sucursal.getBandejas(vistaAgregarUbicacion.obtenerNombreProductoTabla(fila));
                    vistaAgregarUbicacion.agregarBandejas(bandejas);
                    vistaAgregarUbicacion.activarBandejas();
                     }else{
                            if((pedido.getDetallePedido().get(fila).getProducto())instanceof Bebida){
                                ArrayList<Freezer> freezers = sucursal.getFreezers();
                                vistaAgregarUbicacion.agregarFreezers(freezers);
                                vistaAgregarUbicacion.activarFreezers();
                     }
               }
               
            }else JOptionPane.showMessageDialog(null, "no selecciono nada");

        }
        
        
        if(e.getActionCommand().equals(vistaAgregarUbicacion.BOTON_AGREGAR_UBICACION)){
            int fila = vistaAgregarUbicacion.obtenerFilaSeleccionada();
            if(fila >= 0){
                if(vistaAgregarUbicacion.obtenerDesplegableBandeja() == null){
                vistaAgregarUbicacion.cargarNombreFreezerTabla(fila, vistaAgregarUbicacion.obtenerDesplegableFreezer());
            }else{
                vistaAgregarUbicacion.cargarNombreBandejaTabla(fila, vistaAgregarUbicacion.obtenerDesplegableBandeja());
            }
                vistaAgregarUbicacion.desactivarBandejas();
                vistaAgregarUbicacion.desactivarFreezers();
                vistaAgregarUbicacion.desactivarBotones();
                vistaAgregarUbicacion.limpiarDesplegables();
            }else JOptionPane.showMessageDialog(null, "vuelva a seleccionar el producto por favor");
        }
        
        if(e.getActionCommand().equals(vistaAgregarUbicacion.BOTON_UTULIZAR_HORNEADAS)){
            int fila  = vistaAgregarUbicacion.obtenerFilaSeleccionada();
            if(fila >= 0){
                if((pedido.getDetallePedido().get(fila).getProducto())instanceof Empanada){
                    vistaAgregarUbicacion.cargarNombreBandejaTabla(fila, "horneadas");
                    vistaAgregarUbicacion.cargarNombreFreezerTabla(fila, "horneadas");
                    vistaAgregarUbicacion.desactivarBandejas();
                    vistaAgregarUbicacion.desactivarFreezers();
                    vistaAgregarUbicacion.desactivarBotones();
                    vistaAgregarUbicacion.limpiarDesplegables();
                }else JOptionPane.showMessageDialog(null, "Seleccione empanadas por favor");
            }else JOptionPane.showMessageDialog(null, "vuelva a seleccionar el producto por favor");
        }
        
        if(e.getActionCommand().equals(vistaAgregarUbicacion.BOTON_CONFIRMAR)){
            JOptionPane.showMessageDialog(null, "el stock antes es "+sucursal.obtenerStockTotal());
            JOptionPane.showMessageDialog(null, "el stock de bebidas antes es "+sucursal.obtenerStockBebidas());
            if(vistaAgregarUbicacion.verificarQueLosCamposEstanCompletos()){
                ArrayList<Bandeja> bandejas = new ArrayList<>();
                for (int i = 0; i < pedido.getDetallePedido().size(); i++) {
                    if(vistaAgregarUbicacion.obtenerNombreBandejaTabla(i) != null){
                        if(vistaAgregarUbicacion.obtenerNombreBandejaTabla(i) != "horneadas"){
                            bandejas.add(sucursal.getBandeja(vistaAgregarUbicacion.obtenerNombreBandejaTabla(i)));
                        }
                    
                    }else{
                        sucursal.descontarStockBebidas(vistaAgregarUbicacion.obtenerNombreProductoTabla(i), this.desConvertirVolumen(vistaAgregarUbicacion.obtenerVolumenTabla(i)));
                    }
                }
                sucursal.descontarStockEmpanadas(bandejas, pedido);
                JOptionPane.showMessageDialog(null, "el stock despues es "+sucursal.obtenerStockTotal());
                JOptionPane.showMessageDialog(null, "el stock de bebidas despues es "+sucursal.obtenerStockBebidas());
                JOptionPane.showMessageDialog(null, "pedido de tipo "+pedido.getClass().getSimpleName());
                
            }else JOptionPane.showMessageDialog(null, "no deje ninugn campo sin ubicacion");
        }
    }

    public void ejecutar() {
        vistaTipoPedido.ejecutar();
        vistaTipoPedido.setControlador(this);
    }
    
    public void inicializarVistaCrearPedidos(){
        vistaCrearPedido.agregarEmpanadas(repositorio.buscarEmpandas());
        vistaCrearPedido.agregarBebidas(repositorio.buscarBebidas());
        vistaCrearPedido.agregarVolumenes(repositorio.buscarVolumen());
    }
    
    public int calcularDescuento(int cantidad){
        int descontado = 0;
        while(cantidad >= 12){
            cantidad = cantidad - 12;
            descontado += 3;
        }
        if(cantidad >= 6) descontado += 1;
        return descontado;
    }
    
    public String convertirVolumen (String volumen) {
        String unidad = null;
            if(Double.parseDouble(volumen) < 1){
                unidad = (Double.toString(Double.parseDouble(volumen)*1000) + "ml");
            }else{
                unidad = (volumen + "L");
            }
            
        return unidad;
    }

    private double desConvertirVolumen(String vol) {
        double volumen = 0;
        
        if("2L".equals(vol))volumen = 2;
        if("1.25L".equals(vol))volumen = 1.25;
        if("750.0ml".equals(vol))volumen = 0.75;
        if("500.0ml".equals(vol))volumen = 0.5;
        
        
        return volumen;
    }

    private IDatosPedido agregarDatosExtra(){
        try {
            return  (IDatosPedido)Class.forName("vista.Pedido"+pedido.getClass().getSimpleName().toString()).newInstance();
        } catch (Exception ex){
            return null;
            }
        
        
    }
    
    private void cargarDetalleEnUbicaciones(Pedido pedido){
        for(int i = 0; i < pedido.getDetallePedido().size(); i++){
            String linea[] = new String[4];
            linea[0] = "" + vistaCrearPedido.obtenerNombreProductoTabla(i);
            if((pedido.getDetallePedido().get(i).getProducto())instanceof Empanada)linea[1] = "" + vistaCrearPedido.obtenerCantidadTabla(i);
            else linea[2] = "" + vistaCrearPedido.obtenerCantidadTabla(i);
            
            vistaAgregarUbicacion.agregarFila(linea);
            
        }
    }
    
}
