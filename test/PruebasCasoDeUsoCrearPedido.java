/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yurema.*;

/**
 *
 * @author luciano
 */
public class PruebasCasoDeUsoCrearPedido {
    private static LineaPedido lp,lp2;
    private static Sucursal su1;
    private static Freezer freezer1,freezer2,freezer3;
    private static Empanada empanadaPollo,empanadaCarne;
    private static Bandeja bandeja1,bandeja2,bandeja3;
    
    
    public PruebasCasoDeUsoCrearPedido() {
    }
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        lp = new LineaPedido();
        
        //------------------------
        
        lp2 = new LineaPedido();
        
        //----------------------
        
        su1 = new Sucursal();
        
        empanadaPollo = new Empanada();
        empanadaPollo.setRelleno("pollo");
        empanadaCarne = new Empanada();
        empanadaCarne.setRelleno("carne");
        
        freezer1 = new Freezer();
        freezer2 = new Freezer();
        freezer3 = new Freezer();
        
        bandeja1 = new Bandeja();
        bandeja2 = new Bandeja();
        bandeja3 = new Bandeja();
        
        bandeja1.setEmpanada(empanadaCarne);
        bandeja1.setCapacidadOcupada(30);
        bandeja2.setEmpanada(empanadaPollo);
        bandeja2.setCapacidadOcupada(30);
        bandeja3.setEmpanada(empanadaCarne);
        bandeja3.setCapacidadOcupada(30);

        freezer1.agregarBandeja(bandeja1);
        freezer2.agregarBandeja(bandeja2);
        freezer3.agregarBandeja(bandeja3);
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
     public void prueba(){
        //configuracion
        
        
        //ejecucion
        String relleno = bandeja1.getEmpanada().getRelleno();
        //validacion

        assertEquals("carne",relleno);
     }
     
     
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
         assertEquals(3, su1.getFreezers().size(),0.0);
         
     }
}
