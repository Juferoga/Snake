package Logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import Presentacion.*;
import Logica.*;
import Datos.*;

/**
 * Comida para a serpiente
 *
 * @author Estudiantes
 *
 */
public class Food extends JPanel {

    private final Main padre;

    protected int posX;
    protected int posY;

    private final Color color = new Color(207, 211, 208);

    /**
     * Crear nueva comida
     *
     * @param posX posicion horizontal de la comida
     * @param posY posicion vertical de la comida
     */
    public Food(final int posX, final int posY, final Main _padre) {
        this.setSize(new Dimension(Data.CASESIZE, Data.CASESIZE));

        this.setLocation(posX * Data.CASESIZE, posY * Data.CASESIZE);

        padre = _padre;

        this.posX = posX;
        this.posY = posY;
    }

    /**
     * CAmbia la posicion de la comida
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
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.drawOval(Data.CASESIZE / 6, Data.CASESIZE / 6, Data.CASESIZE - (Data.CASESIZE / 3) - 1,
                Data.CASESIZE - (Data.CASESIZE / 3) - 1);

        g.setColor(Color.white);
        g.fillOval(Data.CASESIZE / 6 + 1, Data.CASESIZE / 6 + 1, Data.CASESIZE - (Data.CASESIZE / 3) - 3,
                Data.CASESIZE - (Data.CASESIZE / 3) - 3);
    }

    /**
     * Verificar si la comida est siendo tocada por el cuerpo
     *
     * @param i
     * @param j
     * @return
     */
    public boolean TestCuerpo(final int i, final int j) {
        boolean res = true;
        for (final Block b : padre.getSerpiente().getCola()) {
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
