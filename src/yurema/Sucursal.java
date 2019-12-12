/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurema;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class Sucursal {
    private String direccion;
    private ArrayList<Freezer> freezers;

    public Sucursal() {
    this.freezers = new ArrayList<>();
    
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
            bandejas.add(b);});
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
    
    public void agregarFreezer(Freezer freezer){
        this.freezers.add(freezer);
    }
}
