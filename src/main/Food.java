package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import main.Main;
import main.Block;

import main.Data;

/**
 * Comida para a serpiente
 *
 * @author Estudiantes
 *
 */
public class Food extends JPanel {

    private Main padre;

    protected int posX;
    protected int posY;

    private Color color = new Color(211, 161, 0);

    /**
     * Crear nueva comida
     *
     * @param posX posicion horizontal de la comida
     * @param posY posicion vertical de la comida
     */
    public Food(int posX, int posY, Main _padre) {
        this.setSize(new Dimension(Data.CASESIZE, Data.CASESIZE));

        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);

        padre = _padre;

        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Change l'emplacement de la food
     *
     * @param posX posicion horizontal de la comida
     * @param posY posicion vertical de la comida
     */
    public void moveIt() {
        int newX = (int) (Math.random() * Data.NBRCASEX);
        int newY = (int) (Math.random() * Data.NBRCASEY);

        while (!TestCuerpo(newX, newY)) {
            newX = (int) (Math.random() * Data.NBRCASEX);
            newY = (int) (Math.random() * Data.NBRCASEY);
        }

        this.posX = newX;
        this.posY = newY;
        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(Data.CASESIZE / 6, Data.CASESIZE / 6,
         Data.CASESIZE - (Data.CASESIZE / 3) - 1, Data.CASESIZE - (Data.CASESIZE / 3) - 1);

        g.setColor(color);
        g.fillOval(Data.CASESIZE / 6 + 1,
         Data.CASESIZE / 6 + 1, Data.CASESIZE - (Data.CASESIZE / 3) - 3,
          Data.CASESIZE - (Data.CASESIZE / 3) - 3);
    }

    /**
     * Verificar si la comida est siendo tocada por el cuerpo
     *
     * @param i
     * @param j
     * @return
     */
    public boolean TestCuerpo(int i, int j) {
        boolean res = true;
        for (Block b : padre.getSerpiente().getCola()) {
            if (i == b.getX() && j == b.getY()) {
                res = false;
            }
        }
        return res;
    }

    /**
     * @return La posicion horizontal de la comida
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return La posicion vertical de la comida
     */
    public int getPosY() {
        return posY;
    }
}
