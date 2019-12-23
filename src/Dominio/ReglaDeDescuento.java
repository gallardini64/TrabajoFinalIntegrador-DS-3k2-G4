/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class ReglaDeDescuento {
    private static ReglaDeDescuento instancia;
    
    public static synchronized ReglaDeDescuento getInstance(){
        if(instancia == null)
        {
            instancia = new ReglaDeDescuento();
        }
        return instancia;
    }
    
    public double aplicarDescuento(LineaPedido lp){
        
        int cantidadNueva = lp.getCantidad();
        
        double subTotalConDescuento = lp.getCantidad() * lp.getProducto().getPrecioUnitario();
        
        if((lp.getProducto())instanceof Bebida)return lp.getProducto().getPrecioUnitario() * lp.getCantidad();
        
        while(cantidadNueva >= 12){
            subTotalConDescuento = subTotalConDescuento - (lp.getProducto().getPrecioUnitario() * 3);
            cantidadNueva = cantidadNueva - 12;
        }   
        if(cantidadNueva >= 6){
            subTotalConDescuento = subTotalConDescuento - (lp.getProducto().getPrecioUnitario() * 1);
        }
        return subTotalConDescuento;
    }
    
    
    
}
