/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import datos.Repositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class Sucursal {
    private String direccion;
    private ArrayList<Freezer> freezers;
    private Repositorio repositorio;
    private ReglaDeDescarte descarte;
    
    
    public Sucursal() {
    this.freezers = new ArrayList<>();
    repositorio = Repositorio.getInstance();
    descarte = ReglaDeDescarte.getInstance();
    }

    public void inicializar (){
        this.freezers = repositorio.buscarFreezers();
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Freezer> getFreezers() {
        return freezers;
    }

    public void setFreezers(ArrayList<Freezer> freezers) {
        this.freezers = freezers;
    }
    
    public int obtenerStock(String relleno){
        ArrayList<Bandeja> bandejas = new ArrayList<Bandeja>();
        int stock = 0;
        
         
        freezers.forEach((f) -> {
            ArrayList<Bandeja> coleccionAuxiliarbandejas = f.getBandejas();
            coleccionAuxiliarbandejas.forEach((b) ->{
            if(descarte.verificarVencimiento(b))bandejas.add(b);
            });
        }); 
        
        
        for(Bandeja b : bandejas){
            
            try {
            if(b.getEmpanada().getRelleno() == relleno){
            stock = stock + b.getCapacidadOcupada();
            }
            } catch (Exception BesNula) {
            }
        }
        return stock;
    }
    
    
    public int obtenerStockTotal(){
        ArrayList<Bandeja> bandejas = new ArrayList<Bandeja>();
        int stock = 0;
        
        freezers.forEach((f) -> {
            ArrayList<Bandeja> coleccionAuxiliarbandejas = f.getBandejas();
            coleccionAuxiliarbandejas.forEach((b) ->{
                if(descarte.verificarVencimiento(b))bandejas.add(b);
            });
        }); 
        for(Bandeja b : bandejas){
            try {
            stock = stock + b.getCapacidadOcupada();
            } catch (Exception BesNula) {
            }
        }
        return stock;
    }
    
    public int obtenerStockBebidas(){
        int stock = 0;
        for(Freezer f : freezers){
            stock += f.getBebidas().size();
        }
        return stock;
    }
    
    public void agregarFreezer(Freezer freezer){
        this.freezers.add(freezer);
    }
    
    public void descontarStockEmpanadas(ArrayList<Bandeja> bandejas,Pedido p ) {
        int i = 0;
        if(!((p)instanceof Encargo)){
            for (LineaPedido lp : p.getDetallePedido()) {
                if((lp.getProducto())instanceof Empanada){
                    for(Freezer f : freezers){
                        for(Bandeja b : f.getBandejas()){
                            try {
                                if(b.equals(bandejas.get(i))){
                                b.setCapacidadOcupada(b.getCapacidadOcupada() - lp.getCantidad());
                            }
                            } catch (Exception e) {
                            }
                        }
                    }
                    i++;
                }
            }
            
            
            
        }
        
    }

    public int obtenerStock(Bebida bebida) {
        int stock = 0, i = 0;
        
        for(Freezer f : freezers){
            for(Bebida b : f.getBebidas()){
                if(b.getNombre() == bebida.getNombre() && b.getVolumen() == bebida.getVolumen()){
                    stock++;
                }    
            }
            
        }
        return stock;
    }

    public ArrayList<Bandeja> getBandejas(String relleno) {
        ArrayList<Bandeja> bandejas = new ArrayList<Bandeja>();
        
        freezers.forEach((f) -> {
            ArrayList<Bandeja> coleccionAuxiliarbandejas = f.getBandejas();
            coleccionAuxiliarbandejas.forEach((b) ->{
            if(descarte.verificarVencimiento(b) && b.getEmpanada().getRelleno().equals(relleno.substring(13,relleno.length()))){
                bandejas.add(b);
            }
            });
        }); 
        
        return bandejas;
        
    }

    public Bandeja getBandeja(String numero) {
        
        for (Freezer freezer : freezers) {
            for (Bandeja bandeja : freezer.getBandejas()) {
                if(bandeja.getNumero() == Integer.parseInt(numero)) return bandeja;
            }
        }
        
        
        return null;
    }

    public void descontarStockBebidas(String bebida, double volumen) {
        for(Freezer freezer : freezers){
            for(Bebida beb : freezer.getBebidas()){
                int i = 0;
                if(beb.getNombre().equals(bebida) && beb.getVolumen() == volumen){
                    freezer.removerBebida(i);
                }
                i++;
            }
        }
    }
    
    
}
