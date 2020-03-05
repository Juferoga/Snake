package main;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Clase de los metodos estaticos para los cuadros de dialogo
 *
 * @author Estudiantes
 */
public class Ventana_Dialogo {

    /**
     * Mensaje de peligro
     *
     * @param parentComponent : Componente Padre
     * @param mess            : Mensaje a mostar
     */
    public static void danger(final Component parentComponent, final String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Peligro", JOptionPane.WARNING_MESSAGE);
    }
}
