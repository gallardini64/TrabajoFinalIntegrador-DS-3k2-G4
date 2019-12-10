/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurema;

import java.util.ArrayList;

/**
 *
 * @author luciano
 */
public class Freezer {
    private ArrayList<Bebida> bebidas; 
    private ArrayList<Lote> lotes; 

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }
    
    public int cantidadBebidas(){
        int cantidad;
        cantidad = bebidas.size();
        return cantidad;
    }
    
    
    
}
