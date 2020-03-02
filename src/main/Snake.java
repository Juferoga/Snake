package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Ventana_Dialogo;
import main.Main;
import main.Food;

/**
 * La cabeza dela serpiente
 *
 * @author Estudiantes
 *
 */
public class Snake extends JPanel implements Runnable, KeyListener {

    public final static short WEST = -1;
    public final static short EST = 1;
    public final static short NORTH = -2;
    public final static short SOUTH = 2;
    public final static short LIVE = 0;
    public final static short DEAD = 1;

    private Main padre;
    private Block cabeza;
    private ArrayList<Block> cola = new ArrayList<Block>();

    private short dir = WEST;
    private short dirAv = WEST;

    private Color color;
    private short estado = LIVE;

    private Food comida;
    private int score = 0;
    private JPanel pc = new JPanel();

    /**
     * Crée un nouveau serpent
     *
     * @param cabeza le block représentant sa tête
     * @param nbrCola le nombre de block en plus de sa tête
     */
    public Snake(Block cabeza, int nbrCola, Main _padr) {
        this.cabeza = cabeza;
        color = new Color(0, 180, 0);
        padre = _padr;
        comida = new Food((int) (Math.random() * Data.NBRCASEX),
                (int) (Math.random() * Data.NBRCASEY), padre);
        for (int i = 0; i < nbrCola; i++)//Añade al cuerpo
        {
            if (i == 0) {
                cola.add(new Block(cabeza));
            } else {
                cola.add(new Block(cola.get(i - 1)));
            }
            cola.get(i).setColor(color);
        }

        //Añade al mapa
        Data.MAP.add(cabeza);
        Data.MAP.add(cola.toArray(new Block[cola.size()]));
        //Data.MAP.add(comida);

        //Agrega el marcador
        pc.add(new JLabel("Marcador: "));
        pc.add(new JLabel(String.valueOf(score)));
    }

    /**
     * Traer de vuelta a la serpiente
     *
     * @param cabeza El bloque que representa la cabeza
     * @param nbrCola El nuemro de bloques detras de la cabeza
     */
    public void reborn(Block cabeza, int nbrCola) {
        this.cabeza = cabeza;
        color = new Color(0, 180, 0);
        score = 0;

        pc.removeAll();
        pc.add(new JLabel("Marcador: "));
        pc.add(new JLabel(String.valueOf(score)));

        cola.removeAll(cola);

        for (int i = 0; i < nbrCola; i++) //Crea el cuerpo de la serpiente
        {
            if (i == 0) {
                cola.add(new Block(cabeza));
            } else {
                cola.add(new Block(cola.get(i - 1)));
            }

            cola.get(i).setColor(color);
        }

        comida = new Food((int) (Math.random() * Data.NBRCASEX), (int) (Math.random() * Data.NBRCASEY), padre);

        Data.MAP.add(cabeza);
        Data.MAP.add(cola.toArray(new Block[cola.size()]));
        Data.MAP.add(comida);

        dir = WEST;
        dirAv = WEST;
        estado = LIVE;
    }

    /**
     * Añade un bloque de mas a la serpiente
     */
    public void addOne() {
        Block b = new Block(cola.get(cola.size() - 1));
        b.setColor(color);

        cola.add(b);
        Data.MAP.add(b);
    }

    /**
     * Avanza la serpiente en un espacio
     */
    public void avanza() {
        for (int k = cola.size() - 1; k >= 0; k--) //reemplaza el Bloque n-1 por el n
        {
            cola.get(k).avanzar();
        }

        if (dir + dirAv != 0) //No puede ir en direccion contraria
        {
            cabeza.avanzar(dir); //Mantenemos la misma direccion
            dirAv = dir;
        } else {
            cabeza.avanzar((short) (dirAv)); //Hace avanzar hacia dir (@dirAV)
        }
        for (int k = 0; k < cola.size(); k++) {
            if (cola.get(k).getLocation().equals(cabeza.getLocation())) 
            //Si la cabeza toca otro bloque de la serpiente, pierde
            {
                estado = DEAD; //La serpiente fallece :'(
                Ventana_Dialogo.danger(null, "Perdiste, Sigue intentando !");
                padre.replay();
            }
        }

        if (cabeza.posX == comida.getPosX() && cabeza.posY == comida.getPosY()) 
        //Si la serpiente se superpone a la comida
        {
            comida.moveIt();
            this.addOne();
            score++;
            ((JLabel) pc.getComponent(1)).setText(String.valueOf(score));
            pc.repaint();
        }
    }

    /**
     * Hilo correr
     */
    public void run() {
        while (true) {
            if (estado == LIVE) //La serpiente se desplaza si sigue viva    
            {
                this.avanza();

                try {
                    Thread.sleep(1040 - 10 * Data.SNAKESPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Cambia la direccion de la serpiente cuando una flecha es presionada
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dir = NORTH;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dir = SOUTH;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dir = WEST;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dir = EST;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    /**
     *
     * @return Bloques de la cola
     */
    public ArrayList<Block> getCola() {
        return cola;
    }

    /**
     * Snake.DEAD: muerta Snake.LIVE: viva
     *
     * @return Estado de la serpiente
     */
    public short getStatue() {
        return estado;
    }

    /**
     * Snake.DEAD: muerta Snake.LIVE: viva
     *
     * @param estado Estado a cambiar de la serpiente
     */
    public void setStatue(short estado) {
        this.estado = estado;
    }

    /**
     *
     * @return Panel de puntaje
     */
    public JPanel getPanel() {
        return this.pc;
    }

    /**
     *
     * @return el puntaje
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score modificar el puntaje
     */
    public void setScore(int score) {
        this.score = score;
    }

}
