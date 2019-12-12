/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurema;

import java.util.Date;

/**
 *
 * @author luciano
 */
public class Bandeja {
    private Empanada empanada;
    private int capacidadOcupada;
    private int numero;
    private int numeroLote;
    private Date fechaProduccion;
    private static final int capacidad = 100;

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    
    
    
    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(int capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }
    
    public Empanada getEmpanada() {
        return empanada;
    }

    public void setEmpanada(Empanada emp) {
        this.empanada = emp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }
    
    
    
}
