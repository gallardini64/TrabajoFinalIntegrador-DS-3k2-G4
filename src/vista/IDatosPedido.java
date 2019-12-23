/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCrearPedido;

/**
 *
 * @author luciano
 */
public interface IDatosPedido {
    void ejecutar();
    void setControlador(ControladorCrearPedido control);
}
