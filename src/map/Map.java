package map;

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

    private int sizeX;
    private int sizeY;

    /**
     * Crear Tablero
     *
     * @param sizeX tamaño X en pixel del tablero
     * @param sizeY tamaño Y en pixel del tablero
     */
    public Map(int sizeX, int sizeY) {
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
    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.sizeX, this.sizeY);

        g.setColor(Color.gray);
        g.drawRect(0, 0, this.sizeX - 1, this.sizeY - 1);
    }

    /**
     * Añade un componente
     *
     * @param array
     */
    public void add(Component[] array) {
        for (Component o : array) {
            this.add(o);
        }
    }

    /**
     * Supprime un componente
     *
     * @param array
     */
    public void remove(Component[] array) {
        for (Component o : array) {
            this.remove(o);
        }
    }
}