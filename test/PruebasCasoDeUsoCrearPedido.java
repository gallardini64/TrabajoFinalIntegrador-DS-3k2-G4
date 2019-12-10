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
    
    
    public PruebasCasoDeUsoCrearPedido() {
    }
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        lp = new LineaPedido();
        
        //------------------------
        
        lp2 = new LineaPedido();
        
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
}
