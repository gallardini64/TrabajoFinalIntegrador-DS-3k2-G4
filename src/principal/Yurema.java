/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.ControladorCrearPedido;
import javax.swing.JOptionPane;
import vista.Menu;

/**
 *
 * @author pdgal
 */
public class Yurema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ControladorCrearPedido control = new ControladorCrearPedido();
        control.ejecutar();
    }
    
}
