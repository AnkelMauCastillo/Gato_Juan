package mx.edu.uacm.acs.proyectojuego.test;

import mx.edu.uacm.acs.proyectojuego.Tablero;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

    @Test
    public void visualizaTablero(){
        Tablero tablero = new Tablero();
        tablero.imprimirTablero();

    }


}