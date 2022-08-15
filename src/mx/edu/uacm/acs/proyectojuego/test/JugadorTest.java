package mx.edu.uacm.acs.proyectojuego.test;

import mx.edu.uacm.acs.proyectojuego.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {
    @Test
    //metodo de prueba que imprime el nombre del jugador
    public void imprimeDatosJugador(){
        Jugador jugador = new Jugador("Eduardo");
        jugador.setSimbolo(jugador.assignaCaracter(1));
        System.out.println(jugador);



    }


    @Test
    //metodo que valida si el caracter esta dentro del intervalo establecido
    public void validaValor(){
        Jugador jugador = new Jugador("Eduardo");
        int contador = 1;
        boolean cerradura = false;

        do {
            System.out.println("Entro");
            if (jugador.validaValorNumerico(contador)) {
                cerradura = true;
                System.out.println("Entro x2");
                jugador.setSimbolo(jugador.assignaCaracter(contador));
            }
            contador--;

        }while (cerradura != true);

        System.out.println(jugador);


    }
}