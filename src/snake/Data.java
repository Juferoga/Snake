package snake;

import map.Map;

/**
 * Clase para los datos del juego
 *
 * @author Estudiantes
 *
 */
public class Data {

    public static short CASESIZE = 20;
    public static short SNAKESIZE = 3;
    public static short NBRCASEX = 30;
    public static short NBRCASEY = 30;
    public static int SNAKESPEED = 80;
    public static Map MAP = new Map(Data.CASESIZE * Data.NBRCASEX, Data.CASESIZE * Data.NBRCASEY);
    /**
     * Cambiando el tamaño se le realiza un resize al tablero
     */
    public static void reborn() {
        MAP = new Map(Data.CASESIZE * Data.NBRCASEX, Data.CASESIZE * Data.NBRCASEY);
    }
}
