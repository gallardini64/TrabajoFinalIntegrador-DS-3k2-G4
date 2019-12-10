/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurema;

/**
 *
 * @author luciano
 */
public class Bebida extends Producto{
    private double volumen;
    private String nombre;

    
    
    public Bebida(double volumen, String nombre) {
        super();
        this.volumen = volumen;
        this.nombre = nombre;
    }

    
    
    
    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
