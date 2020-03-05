package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import main.Data;
import main.Snake;

/**
 * Clase principal del Snake
 *
 * @author Estudiantes
 *
 */
public class Main extends JFrame {

    private final Main before = this;
    private final Block cabeza;
    private final Snake serpiente;
    private final JPanel mapPanel = new JPanel();
    private final Thread thread;

    public static void main(final String[] args) {
        new Main();
    }

    /**
     * Constructor para la ventana de juego
     */
    public Main() {
        this.setTitle("Snake - UD");
        this.setLayout(new BorderLayout());

        // Creacion del MENU
        final JMenuBar mb = new JMenuBar();
        final JMenu juego = new JMenu("Juego");
        final JMenuItem opcion = new JMenuItem("Opciones");
        final JMenuItem jugar = new JMenuItem("Jugar");
        final JMenuItem cerrar = new JMenuItem("Cerrar");

        opcion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        jugar.addActionListener(new Juego(this));
        opcion.addActionListener(new Opcion(this));
        cerrar.addActionListener(new Cerrar(this));

        juego.add(jugar);
        juego.add(opcion);
        juego.add(cerrar);

        //mb.add(juego);

        this.getContentPane().add(mb, BorderLayout.NORTH);

        // Creación de la serpiente 
        mapPanel.setLayout(new FlowLayout());
        mapPanel.add(Data.MAP, BorderLayout.CENTER);
        this.getContentPane().add(mapPanel);

        cabeza = new Block((Data.NBRCASEX - 1) / 2, (Data.NBRCASEY - 1) / 2);
        cabeza.setColor(new Color(121, 173, 69));
        serpiente = new Snake(cabeza, Data.SNAKESIZE, this);

        thread = new Thread(serpiente);
        thread.start();
        this.addKeyListener(serpiente);

        // Creacion del contador
        //this.add(serpiente.getPanel(), BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Volver a jugar
     */
    public void replay() {
        Data.MAP.removeAll();
        Data.MAP.repaint();

        mapPanel.removeAll();
        mapPanel.repaint();

        this.remove(mapPanel);
        mapPanel.remove(Data.MAP);
        Data.reborn();

        mapPanel.add(Data.MAP, BorderLayout.CENTER);
        this.getContentPane().add(mapPanel);

        cabeza.moveIt((Data.NBRCASEX - 1) / 2, (Data.NBRCASEY - 1) / 2);
        cabeza.setColor(new Color(121, 173, 69));
        serpiente.reborn(cabeza, Data.SNAKESIZE);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     *  get de la serpiente
     *  GET: Permite obtener los datos de la serpiente
     * @return serpiente 
     */
    public Snake getSerpiente() {
        return serpiente;
    }
    /**
     * get del hilo 
     * THREAD : Se utiliza para ejecutar dos procesos del programa a la vez
     *          info:  https://www.infor.uva.es/~fdiaz/sd/doc/hilos
     * @return hilo
     */
    public Thread getThread() {
        return thread;
    }

}
