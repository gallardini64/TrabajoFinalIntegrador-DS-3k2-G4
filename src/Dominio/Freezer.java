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
public class Freezer {
    private ArrayList<Bebida> bebidas; 
    private ArrayList<Bandeja> bandejas;
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Freezer() {
    this.bandejas = new ArrayList<>();
    this.bebidas = new ArrayList<>();
    }
    
    
    
    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Bandeja> getBandejas() {
        return bandejas;
    }

    public void setBandejas(ArrayList<Bandeja> lotes) {
        this.bandejas = lotes;
    }
    
    public int cantidadBebidas(){
        int cantidad;
        cantidad = bebidas.size();
        return cantidad;
    }
    
    public void agregarBandeja(Bandeja bandeja){
        this.bandejas.add(bandeja);
    }

    public void agregarBebida(Bebida bebida) {
        this.bebidas.add(bebida);
    }

    void removerBebida(int i) {
        bebidas.remove(i);
    }
    
}
