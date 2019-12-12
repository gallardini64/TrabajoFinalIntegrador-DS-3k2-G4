/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurema;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author luciano
 */
public class Encargo extends Pedido{
    private Cliente cliente;
    private Date fechaDeEntrega;
    private String direccionDeEntrega;



    @Override
    public void descontarStock(ArrayList<Bandeja> bandejas, ArrayList<Object> cantidades) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
