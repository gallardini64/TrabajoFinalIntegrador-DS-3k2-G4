/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luciano
 */
public class ReglaDeDescarte {
    private static ReglaDeDescarte instancia;
    
    public static synchronized ReglaDeDescarte getInstance(){
        if(instancia == null)
        {
            instancia = new ReglaDeDescarte();
        }
        return instancia;
    }
    
    Calendar caledario = Calendar.getInstance();
        int año = caledario.get(Calendar.YEAR);
        int mes = caledario.get(Calendar.MONTH);
        int dia = caledario.get(Calendar.DAY_OF_MONTH);
        Date fecha = new Date(año, mes, dia);
    
    
    
    
    public boolean verificarVencimiento (Bandeja bandeja){
        if(bandeja.getFechaProduccion().getYear() == fecha.getYear() ){
            if(bandeja.getFechaProduccion().getMonth() == fecha.getMonth()){
                if(bandeja.getFechaProduccion().getDay() >= fecha.getDay()){
                    return true;
                }
            }
            
        }
        
        
        return false;
    }
    
}
