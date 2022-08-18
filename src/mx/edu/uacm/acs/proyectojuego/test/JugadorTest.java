package mx.edu.uacm.acs.proyectojuego.test;

import mx.edu.uacm.acs.proyectojuego.Jugador;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {
    @Test
    //metodo de prueba que imprime el nombre del jugador
    public void imprimeDatosJugador() throws IllegalAccessException {
        Jugador jugador = new Jugador("Eduardo");
        jugador.setSimbolo(jugador.assignaCaracter(1));
        System.out.println(jugador);



    }


    @Test
    //metodo que valida si el caracter esta dentro del intervalo establecido
    public void validaValor() throws IllegalAccessException {
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

    @Test
    public void validarCaracter() throws IllegalAccessException {

        int valorCaracter = 2;
        Jugador jugador1 = new Jugador();
        jugador1.setSimbolo(jugador1.assignaCaracter(valorCaracter));
        jugador1.setNombre("Angel");

        if (valorCaracter == 1) {
            Assert.assertEquals(new Jugador("Angel", "X").toString(),jugador1.toString());
        } else if (valorCaracter == 2) {

            Assert.assertEquals(new Jugador("Angel", "O").toString(),jugador1.toString());

        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void pruebaValorFueraDelRango()  {

        try {
            System.out.println(new Jugador().assignaCaracter(1));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}