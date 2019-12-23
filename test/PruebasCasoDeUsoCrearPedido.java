/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dominio.Sucursal;
import Dominio.Bandeja;
import Dominio.Empanada;
import Dominio.Local;
import Dominio.Bebida;
import Dominio.Pedido;
import Dominio.LineaPedido;
import Dominio.Freezer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luciano
 */
public class PruebasCasoDeUsoCrearPedido {
    private static LineaPedido lp,lp2,lp3;
    private static Sucursal su1,su2;
    private static Pedido pedido;
    private static Freezer freezer1,freezer2,freezer3,freezer4,freezer5,freezer6;
    private static Empanada empanadaPollo,empanadaCarne;
    private static Bandeja bandeja1,bandeja2,bandeja3,bandeja4,bandeja5,bandeja6;
    private int[] descuento = new int[10];
    
    
    
    public PruebasCasoDeUsoCrearPedido() {
    }
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        lp = new LineaPedido();
        
        lp3 = new LineaPedido();
        
        //------------------------
        
        lp2 = new LineaPedido();
        
        //----------------------
        
        su1 = new Sucursal();
        su2 = new Sucursal();
        
        empanadaPollo = new Empanada();
        empanadaPollo.setRelleno("pollo");
        empanadaCarne = new Empanada();
        empanadaCarne.setRelleno("carne");
        
       
        
        freezer1 = new Freezer();
        freezer2 = new Freezer();
        freezer3 = new Freezer();
        freezer4 = new Freezer();
        freezer5 = new Freezer();
        freezer6 = new Freezer();
        
        bandeja1 = new Bandeja();
        bandeja2 = new Bandeja();
        bandeja3 = new Bandeja();
        bandeja4 = new Bandeja();
        bandeja5 = new Bandeja();
        bandeja6 = new Bandeja();
        
        Calendar caledario = Calendar.getInstance();
        int año = caledario.get(Calendar.YEAR);
        int mes = caledario.get(Calendar.MONTH);
        int dia = caledario.get(Calendar.DAY_OF_MONTH);
        Date fecha = new Date(año, mes, dia);
        
        bandeja1.setEmpanada(empanadaCarne);
        bandeja1.setCapacidadOcupada(30);
        bandeja1.setFechaProduccion(fecha);
        
        bandeja2.setEmpanada(empanadaPollo);
        bandeja2.setCapacidadOcupada(30);
        bandeja2.setFechaProduccion(fecha);
        
        bandeja3.setEmpanada(empanadaCarne);
        bandeja3.setCapacidadOcupada(30);
        bandeja3.setFechaProduccion(fecha);
        
        bandeja4.setEmpanada(empanadaCarne);
        bandeja4.setCapacidadOcupada(30);
        bandeja4.setFechaProduccion(fecha);
        
        bandeja5.setEmpanada(empanadaPollo);
        bandeja5.setCapacidadOcupada(30);
        bandeja5.setFechaProduccion(fecha);
        
        bandeja6.setEmpanada(empanadaCarne);
        bandeja6.setCapacidadOcupada(30);
        bandeja6.setFechaProduccion(fecha);
        
        freezer1.agregarBandeja(bandeja1);
        freezer2.agregarBandeja(bandeja2);
        freezer3.agregarBandeja(bandeja3);
        freezer4.agregarBandeja(bandeja4);
        freezer5.agregarBandeja(bandeja5);
        freezer6.agregarBandeja(bandeja6);
        
        
        //-------------------------------
        
        pedido = new Local();
        
        //------------------------------
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
     public void probarQueElConteoDelStockEsCorrecto(){
        //configuracion
        su1.agregarFreezer(freezer1);
        su1.agregarFreezer(freezer2);
        su1.agregarFreezer(freezer3);
        
        //ejecucion
        int stock = su1.obtenerStock("carne");
        
        //validacion
         assertEquals(60, stock,0.0);
         
     }
     
     
     @Test
     public void probarDescuentoDeLaDocenaDeEmpanadas(){
        //configuracion
        
        Empanada empanada = new Empanada();
        empanada.setPrecioUnitario(10);
        empanada.setRelleno("pollo");
        lp.setProducto(empanada);
        lp.setCantidad(12);
        
        //ejecucion
        lp.aplicarDescuento(lp);
        double precioConDescuento = lp.getSubtotal();
        //validacion
         assertEquals(90, precioConDescuento,0.0);
        
     }
     @Test
     public void probarDescuentoDeLaMediaDocenaDeEmpanadas(){
        //configuracion
        
        Empanada empanada = new Empanada();
        empanada.setPrecioUnitario(10);
        empanada.setRelleno("pollo");
        lp.setProducto(empanada);
        lp.setCantidad(6);
        
        //ejecucion
        lp.aplicarDescuento(lp);
        double precioConDescuento = lp.getSubtotal();
        //validacion
         assertEquals(50, precioConDescuento,0.0);
        
     }
     
     
     @Test
     public void probarQueLasBebidasNoSeLesAplicaDescuento(){
        //configuracion
        
        Bebida bebida = new Bebida(1, "coca-cola");
        bebida.setPrecioUnitario(10);
        lp.setProducto(bebida);
        lp.setCantidad(12);
        //ejecucion
        lp.aplicarDescuento(lp);
        double precioSinDescuento = lp.getSubtotal();
        //validacion
         assertEquals(120, precioSinDescuento,0.0);
     }
     
     @Test
     public void probarQueElDescuetoDelStockEsCorrecto(){
        //configuracion
        
        ArrayList<Bandeja> bandejas = new ArrayList<Bandeja>();
        
        su2.agregarFreezer(freezer4);
        su2.agregarFreezer(freezer5);
        su2.agregarFreezer(freezer6);
        
        bandejas.add(bandeja4);
        bandejas.add(bandeja5);
        bandejas.add(bandeja6);
        
        lp.setProducto(empanadaPollo);
        lp2.setProducto(empanadaPollo);
        lp3.setProducto(empanadaPollo);
        
        
        lp.setCantidad(10);
        lp2.setCantidad(10);
        lp3.setCantidad(10);
        
        pedido.agregarLineaPedido(lp);
        pedido.agregarLineaPedido(lp2);
        pedido.agregarLineaPedido(lp3);
        
        //ejecucion
        su2.descontarStockEmpanadas(bandejas,pedido);
        int stock = su2.obtenerStockTotal();
        
        //validacion
         assertEquals(60, stock,0.0);
        
     }
}
