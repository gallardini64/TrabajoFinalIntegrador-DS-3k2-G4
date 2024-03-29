/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author luciano
 */
public class LineaPedido { 
    private Producto producto;
    private double subtotal;
    private int cantidad;
    private ReglaDeDescuento regla;
    
    public LineaPedido() {
        this.regla = ReglaDeDescuento.getInstance();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Empanada producto) {
        this.producto = producto;
    }
    
    public void setProducto(Bebida producto) {
        this.producto = producto;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public void calcularSubTotal(){
        this.subtotal = regla.aplicarDescuento(this);
        
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void aplicarDescuento (LineaPedido lp){
        lp.setSubtotal(ReglaDeDescuento.getInstance().aplicarDescuento(lp));
    }

    
    
}
