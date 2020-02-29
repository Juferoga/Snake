package Componentes;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Clase de los metodos estaticos para los cuadros de dialogo
 *
 * @author Estudiantes
 */
public class Ventana_Dialogo {

    /**
     * Mensaje o caja de mensaje
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     */    
    public static void message(Component parentComponent, String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Mensaje", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Mensaje de error
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     */
    public static void erreur(Component parentComponent, String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje de peligro
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     */
    public static void danger(Component parentComponent, String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Peligro", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Mensaje de Alerta
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     */
    public static void attention(Component parentComponent, String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Antencion!!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Mensaje de Informacion
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     */
    public static void info(Component parentComponent, String mess) {
        JOptionPane.showMessageDialog(parentComponent, mess, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Caja de dialogo que Pide ingresar un texto
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     * @param title : El titulo del Mensaje
     * @return Retorna el texto ingresado por el usuario
     */
    public static String prompt(Component parentComponent, String mess, String title) {
        String rep = JOptionPane.showInputDialog(parentComponent,
                mess,
                title,
                JOptionPane.QUESTION_MESSAGE);

        return rep;
    }

    /**
     * Caja de dialogo con un boton de OK y un boton CANCEL
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     * @return retorna true si se clikea sobre OK y false en el caso opuesto
     */
    public static boolean confirm(Component parentComponent, String mess) {
        int rep = JOptionPane.showConfirmDialog(parentComponent, mess, "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rep == JOptionPane.CANCEL_OPTION || rep == JOptionPane.CLOSED_OPTION || rep == JOptionPane.NO_OPTION) {
            return false;
        }
        return true;
    }

    /**
     * Caja de dialogo con un boton de YES y un boton NO
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     * @return retorna true si se clikea sobre YES y false en el caso opuesto
     */
    public static boolean yesNo(Component parentComponent, String mess) {
        int rep = JOptionPane.showConfirmDialog(parentComponent, mess, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rep == JOptionPane.NO_OPTION || rep == JOptionPane.CLOSED_OPTION || rep == JOptionPane.NO_OPTION) {
            return false;
        }
        return true;
    }

    /**
     * Caja de dialogo con un boton de YES, un boton NO y un boton
     * CANCEL
     *
     * @param parentComponent : Componente Padre
     * @return Devuelve en el caso opuesto, 0 para CANCEL y 1 para YES
     */
    public static int yesNoCancel(Component parentComponent, String mess) {
        int rep = JOptionPane.showConfirmDialog(parentComponent, mess, "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rep == JOptionPane.CLOSED_OPTION || rep == JOptionPane.CANCEL_OPTION) {
            return 0;
        } else if (rep == JOptionPane.NO_OPTION) {
            return -1;
        }
        return 1;
    }

    /**
     * @param parentComponent
     * @param mess
     * @param titre
     * @param choix
     * @return Retorna un entero segun la respuesta del usuario
     * @deprecated
     * @see #listDialog(Component, String, String, String[])
     */
    public static int multiChoix(Component parentComponent, String mess, String titre, String[] choix) {
        int n = JOptionPane.showOptionDialog(parentComponent, mess, titre, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, "Cancelar");

        return n;
    }

    /**
     * Caja de dialogo con caja de eleccion (ListBox)
     *
     * @param parentComponent : Componente Padre
     * @param mess : Mensaje a mostar
     * @param title : Titulo de la caja de dialogo
     * @param list : Una lista forma de String[]
     * @return Retorna la eleccion del usuario en forma de String
     */
    public static String listDialog(Component parentComponent, String mess, String title, String[] list) {
        String str = (String) JOptionPane.showInputDialog(parentComponent, mess, title, JOptionPane.QUESTION_MESSAGE, null, list, "null");
        return str;
    }
}
