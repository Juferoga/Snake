/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abandona el juego y cierra los procesos ejecutados
 *
 * @author Estudiantes
 */
public class Cerrar implements ActionListener {

    private Main padre;

    public Cerrar(Main padre) {
        this.padre = padre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        padre.getThread().resume();
        padre.getThread().stop();
        padre.dispose();

    }

}
