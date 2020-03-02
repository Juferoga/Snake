package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import main.Data;
import static main.Data.NBRCASEX;
import static main.Data.NBRCASEY;
import static main.Data.SNAKESPEED;

/**
 * Caja de dialogo de la opcion
 * clase que permite generar las opciones del juego 
 * @author Estudiante
 *
 */
public class Opcion extends JDialog implements ActionListener {

    private Main padre;
    private final Opcion before = this;

    private JSlider speed = new JSlider(0, 100, SNAKESPEED);
    private JSlider nbrCaseX = new JSlider(10, 100, NBRCASEY);
    private JSlider nbrCaseY = new JSlider(10, 100, NBRCASEX);
    private JButton but = new JButton("Confirmar");

    private JPanel block1 = new JPanel();
    private JPanel block2 = new JPanel();
    private JPanel block3 = new JPanel();
    private JPanel block4 = new JPanel();

    /**
     * Constructor para la caja de dialogo opción
     * @param _padre Clase padre
     */
    public Opcion(Main _padre) {
        super(new JDialog(), "Opciones", true);

        this.padre = _padre;

        this.setResizable(true);
        this.setLayout(new GridLayout(4, 1));
        this.setPreferredSize(new Dimension(600, 140));
        
        //Velocidad
        
        block1.setLayout(new FlowLayout());

        speed.setMajorTickSpacing(10);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);

        block1.add(new JLabel("Velocidad: "));
        block1.add(speed);

        // Numero de filas
        
        block2.setLayout(new FlowLayout());

        nbrCaseX.setMajorTickSpacing(10);
        nbrCaseX.setPaintTicks(true);
        nbrCaseX.setPaintLabels(true);

        block2.add(new JLabel("Numero de filas: "));
        block2.add(nbrCaseX);

        // Numero de columnas
        
        block3.setLayout(new FlowLayout());

        nbrCaseY.setMajorTickSpacing(10);
        nbrCaseY.setPaintTicks(true);
        nbrCaseY.setPaintLabels(true);

        block3.add(new JLabel("Numero de columnas: "));
        block3.add(nbrCaseY);

        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Data.NBRCASEX = (short) before.nbrCaseX.getValue();
                Data.NBRCASEY = (short) before.nbrCaseY.getValue();
                Data.SNAKESPEED = speed.getValue();
                padre.getThread().resume();

                before.dispose();
                padre.replay();
            }
        });

        block4.setLayout(new FlowLayout());
        block4.add(but);

        this.add(block1);
        this.add(block2);
        this.add(block3);
        this.add(block4);

        this.setSize(new Dimension(350, 250));
    }
    /**
     * permite ejecutar de nuevo el juego cuando se cierran las opciones
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        padre.getThread().suspend();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
