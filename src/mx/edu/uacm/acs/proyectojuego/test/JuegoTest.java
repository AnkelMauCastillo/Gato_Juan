package mx.edu.uacm.acs.proyectojuego.test;

import mx.edu.uacm.acs.proyectojuego.Juego;
import mx.edu.uacm.acs.proyectojuego.Jugador;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JuegoTest {
    @Test
    //metodo de prueba que imprime una lista de nombres de jugadores
    public void ImprimeNombreArrayJugadores(){
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        for (int i = 0; i < jugadores.size(); i++) {
            String nombre = juego.asignaNombreJugadores(jugadores.get(i),i);
            jugadores.get(i).setNombre(nombre);

        }
        System.out.println(jugadores.toString());



    }
    @Test
    //metodo de prueba que imprime una lista de jugadores por su caracter
    public void ImprimeNombreArraySimbolosYNombres(){
        Juego juego = new Juego();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        for (int i = 0; i < jugadores.size(); i++) {
            String nombre = juego.asignaNombreJugadores(jugadores.get(i),i);
            jugadores.get(i).setNombre(nombre);
            jugadores.get(i).setSimbolo(jugadores.get(i).assignaCaracter(i + 1));

        }
        System.out.println(jugadores.toString());


    }

}