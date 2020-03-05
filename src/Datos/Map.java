package Datos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Tablero en el que se mueve la serpiente
 *
 * @author Estudiantes
 *
 */
public class Map extends JPanel {

    private final int sizeX;
    private final int sizeY;

    /**
     * Crear Tablero
     *
     * @param sizeX tamaño X en pixel del tablero
     * @param sizeY tamaño Y en pixel del tablero
     */
    public Map(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.setSize(sizeX, sizeY);
        this.setPreferredSize(new Dimension(sizeX, sizeY));
        this.setLayout(null);
    }

    /**
     * Definicion del color de fondo del tablero y los bordes del mapa
     *
     * @param g
     */
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.sizeX, this.sizeY);

        g.setColor(Color.black);
        g.drawRect(0, 0, this.sizeX - 1, this.sizeY - 1);
    }

    /**
     * Añade un componente
     *
     * @param array
     */
    public void add(final Component[] array) {
        for (final Component o : array) {
            this.add(o);
        }
    }

    /**
     * Supprime un componente
     *
     * @param array
     */
    public void remove(final Component[] array) {
        for (final Component o : array) {
            this.remove(o);
        }
    }
}