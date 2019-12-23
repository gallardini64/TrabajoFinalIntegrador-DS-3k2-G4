/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author luciano
 */
public class Delivery extends Pedido{
    private String nombreFamilia;
    private String direccionEntrega;
    private boolean enCamino;

    public Delivery() {
        this.enCamino = false;
    }
    
    
    
    public Delivery(String nombreFamilia, String direccionEntrega) {
        this.nombreFamilia = nombreFamilia;
        this.direccionEntrega = direccionEntrega;
        this.enCamino = false;
    }
    
    
    

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public boolean isEnCamino() {
        return enCamino;
    }

    public void setEnCamino(boolean enCamino) {
        this.enCamino = enCamino;
    }

    


        
    
    
}
