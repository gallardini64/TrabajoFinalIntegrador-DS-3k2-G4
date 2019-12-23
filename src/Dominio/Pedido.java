/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public abstract class Pedido {
    private int numero;
    private Empleado empleado;
    private Estado estado;
    private ArrayList<LineaPedido> detallePedido = new ArrayList<LineaPedido>();
    private double total;

    public Pedido() {
    
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    public ArrayList<LineaPedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(ArrayList<LineaPedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public void agregarLineaPedido(LineaPedido linea) {
        this.detallePedido.add(linea);
    }
    
    
    public int getNumero() {
        return numero;
    }
    
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public LineaPedido obtenerUltimaLineaPedido(){
        return this.detallePedido.get(this.detallePedido.size() - 1);
    }

    public void agregarLineaPedido(Empanada empanada, int cantidad) {
        LineaPedido lp = new LineaPedido();
        lp.setProducto(empanada);
        lp.setCantidad(cantidad);
        lp.calcularSubTotal();
        
        this.agregarLineaPedido(lp);
    }

    public void agregarLineaPedido(Bebida bebida) {
        LineaPedido lp = new LineaPedido();
        lp.setProducto(bebida);
        lp.setCantidad(1);
        lp.calcularSubTotal();
        
        this.agregarLineaPedido(lp);
    }

    public void eliminarLineaPedido(int fila) {
        detallePedido.remove(fila);
    }

    public void finalizar(int numero) {
         this.numero = numero;
    }

    
    
    
    
}
