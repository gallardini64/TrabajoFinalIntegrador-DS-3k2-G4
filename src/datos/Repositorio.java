/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.Bandeja;
import Dominio.Bebida;
import Dominio.Empanada;
import Dominio.Freezer;
import Dominio.Pedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luciano
 */
 public class Repositorio {
     private static Repositorio instancia;
     private String[] empanadas,bebidas,volumenes;
     private int i = 0;
     private ArrayList<Pedido> pedidos;
     
     protected Repositorio() {
         empanadas = new String[4];
         bebidas = new String[5];
         volumenes = new String[4];
         pedidos = new ArrayList<>();
    }
    
    public static synchronized Repositorio getInstance(){
        if(instancia == null)
        {
            instancia = new Repositorio();
        }
        return instancia;
    }
    
    
    public Empanada getEmpanda(String relleno){
        
        Empanada emp = new Empanada();
        emp.setRelleno(relleno);
        if("Arabe".equals(relleno) && "Carne".equals(relleno))emp.setPrecioUnitario(15);
        else emp.setPrecioUnitario(10);
        
        return emp;
        
    }
    
    public Bebida getBebida(Bebida bebida){
        
        
        if("Coca-cola".equals(bebida.getNombre()) || "Manaos-de-uva".equals(bebida.getNombre()))bebida.setPrecioUnitario(70);
        else bebida.setPrecioUnitario(30);
        
        return bebida;
        
    }
    
    
    public String[] buscarEmpandas(){
        
        empanadas[0] = "Pollo";
        empanadas[1] = "Jamon y Queso";
        empanadas[2] = "Carne";
        empanadas[3] = "Arabe";
        
        
        return empanadas;
    }

    public String[] buscarBebidas() {
        
        bebidas[0] = "Coca-cola";
        bebidas[1] = "Fanta";
        bebidas[2] = "Sprite";
        bebidas[3] = "Pepsi";
        bebidas[4] = "Manaos-de-uva";
        
        
        
        return bebidas;
    }
    
    public String[] buscarVolumen() {
        volumenes[0] = "2";
        volumenes[1] = "1.25";
        volumenes[2] = "0.75";
        volumenes[3] = "0.5";
        
        
        
        return volumenes;
    }

    public ArrayList<Freezer> buscarFreezers() {
        ArrayList<Freezer> freezers = new ArrayList<>();
        Freezer freezer1 = new Freezer();
        freezer1.setNumero(1);
        Freezer freezer2 = new Freezer();
        freezer2.setNumero(2);
        
        
        Bandeja bandeja1 = new Bandeja();
        bandeja1.setNumero(1);
        Bandeja bandeja2 = new Bandeja();
        bandeja2.setNumero(2);
        Bandeja bandeja3 = new Bandeja();
        bandeja3.setNumero(3);
        Bandeja bandeja4 = new Bandeja();
        bandeja4.setNumero(4);
        
        Bebida coca = new Bebida();
        coca.setPrecioUnitario(70);
        Bebida coca2 = new Bebida();
        coca2.setPrecioUnitario(35);
        Bebida fanta = new Bebida();
        fanta.setPrecioUnitario(45);
        Bebida sprite = new Bebida();
        sprite.setPrecioUnitario(30);
        Bebida pepsi = new Bebida();
        pepsi.setPrecioUnitario(50);
        Bebida manaos = new Bebida();
        manaos.setPrecioUnitario(50);
        
        
        Empanada empanadaPollo = new Empanada();
        Empanada empanadaCarne = new Empanada();
        Empanada empanadaJyQ = new Empanada();
        Empanada empanadaArabe = new Empanada();
        
        empanadaPollo.setRelleno("Pollo");
        empanadaCarne.setRelleno("Carne");
        empanadaJyQ.setRelleno("Jamon y Queso");
        empanadaArabe.setRelleno("Arabe");
        
        Calendar caledario = Calendar.getInstance();
        int año = caledario.get(Calendar.YEAR);
        int mes = caledario.get(Calendar.MONTH);
        int dia = caledario.get(Calendar.DAY_OF_MONTH);
        Date fecha = new Date(año, mes, dia);
        
       bandeja1.setEmpanada(empanadaPollo);
       bandeja1.setCapacidadOcupada(200);
       bandeja1.setFechaProduccion(fecha);
       freezer1.agregarBandeja(bandeja1);
       bandeja2.setEmpanada(empanadaCarne);
       bandeja2.setCapacidadOcupada(200);
       bandeja2.setFechaProduccion(fecha);
       freezer1.agregarBandeja(bandeja2);
       
       
       bandeja3.setEmpanada(empanadaJyQ);
       bandeja3.setCapacidadOcupada(200);
       bandeja3.setFechaProduccion(fecha);
       freezer2.agregarBandeja(bandeja3);
       bandeja4.setEmpanada(empanadaArabe);
       bandeja4.setCapacidadOcupada(200);
       bandeja4.setFechaProduccion(fecha);
       freezer2.agregarBandeja(bandeja4);
        
       coca.setNombre("Coca-cola");
       coca2.setNombre("Coca-cola");
       fanta.setNombre("Fanta");
       sprite.setNombre("Sprite");
       pepsi.setNombre("Pepsi");
       manaos.setNombre("Manaos-de-uva");
       
       coca.setVolumen(2);
       coca2.setVolumen(1.25);
       fanta.setVolumen(0.5);
       sprite.setVolumen(0.75);
       manaos.setVolumen(2);
       
       freezer1.agregarBebida(coca);
       freezer1.agregarBebida(fanta);
       freezer2.agregarBebida(sprite);
       freezer2.agregarBebida(coca2);
       freezer2.agregarBebida(manaos);
       
       
       
       freezers.add(freezer1);
       freezers.add(freezer2);
        
       return freezers;
    }

    public int obtenerNuenoNumeroPedido() {
        i++;
        return i;
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    
    
    
    
}
