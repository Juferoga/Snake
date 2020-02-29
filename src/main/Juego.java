/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Permite re-ejecutar el juego
 * @author Estudiantes
 */
public class Juego implements ActionListener {

    private Main parent;

    
    /**
     * Reinicializa el padre
     * @param parent 
     */
    public Juego(Main parent) {
        this.parent = parent;
    }

    /**
     * Permite re-lanzar el hilo
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.replay();
        parent.getThread().resume();

    }

}
