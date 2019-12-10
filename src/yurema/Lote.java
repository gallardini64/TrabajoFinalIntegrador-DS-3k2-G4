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
public class Lote {
    private Empanada emp;
    private int capacidadOcupada;
    private int numero;
    private Date fechaProduccion;
    private static final int capacidad = 100;

    
    
    
    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(int capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }
    
    public Empanada getEmp() {
        return emp;
    }

    public void setEmp(Empanada emp) {
        this.emp = emp;
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
