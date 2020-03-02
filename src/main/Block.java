package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Bloque o cuerpo de la serpiente
 *
 * @author Estudiantes
 *
 */
public class Block extends JPanel {

    protected int posX;
    protected int posY;
    private Block bloqueInicial;
    private Color color = Color.PINK;

    /**
     * Crea un bloque de serpiente que estara pegado al bloque Inicial
     *
     * @param bloqueInicial Bloque que seguira
     */
    public Block(final Block bloqueInicial) {
        this.bloqueInicial = bloqueInicial;
        this.posX = bloqueInicial.posX + 1;
        this.posY = bloqueInicial.posY;

        this.setSize(new Dimension(Data.CASESIZE, Data.CASESIZE));
        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    /**
     * bloque en la posicion (posX, posY)
     *
     * @param posX posicion X del Bloque
     * @param posY posicion Y de la Serpiente
     */
    public Block(final int posX, final int posY) {
        this.posX = posX;
        this.posY = posY;

        this.setSize(new Dimension(Data.CASESIZE, Data.CASESIZE));
        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    /**
     * Avanzar del bloque inicial al bloque que sigue
     */
    protected void avanzar() {
        this.posX = bloqueInicial.posX;
        this.posY = bloqueInicial.posY;

        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    /**
     * block.WEST: Posicion a la izquierda
     * block.EST: Psicion a la derecha
     * block.NORTH: Posicion hacia arriba
     * block.SOUTH: Posicion hacia abajo
     * Hacer avanzar a la serpiente a la posicion que le indique @param dir
     *
     * @param dir direccion a la va
     */
    protected void avanzar(final short dir) {
        if (dir == Snake.EST) {
            posX++;
        } else if (dir == Snake.WEST) {
            posX--;
        } else if (dir == Snake.NORTH) {
            posY--;
        } else if (dir == Snake.SOUTH) {
            posY++;
        }

        // Permite a la serpiente regresar al tablero por el extremo contrario
        if (posX < 0 && dir == Snake.WEST) {
            posX = Data.NBRCASEX - 1;
        }
        if (posX >= Data.NBRCASEX && dir == Snake.EST) {
            posX = 0;
        }

        if (posY < 0 && dir == Snake.NORTH) {
            posY = Data.NBRCASEY - 1;
        }
        if (posY >= Data.NBRCASEY && dir == Snake.SOUTH) {
            posY = 0;
        }

        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    /**
     * Hacer que el bloque se mueva a la posición (posX, posY)
     *
     * @param posX posicion X del bloque
     * @param posY posicion Y de la serpiente
     */
    public void moveIt(final int posX, final int posY) {
        this.posX = posX;
        this.posY = posY;

        this.setSize(new Dimension(Data.CASESIZE, Data.CASESIZE));
        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    /**
     * Dibujando el bloque
     *
     * @param g
     */
    public void paintComponent(final Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, Data.CASESIZE - 1, Data.CASESIZE - 1);

        g.setColor(color);
        g.fillOval(1, 1, Data.CASESIZE - 3, Data.CASESIZE - 3);
    }

    /**
     * Selecion del color del bloque
     *
     * @param color Color del bloque
     */
    public void setColor(final Color color) {
        this.color = color;
    }

}
