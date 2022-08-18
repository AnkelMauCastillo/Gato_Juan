package mx.edu.uacm.acs.proyectojuego;
public class Jugador {
    private String nombre;
    private String simbolo;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Jugador:"+ nombre + ", simbolo=" + simbolo;
    }

    public String assignaCaracter(int valorCaracter) throws IllegalAccessException {
        Jugador jugador = new Jugador();

        if (valorCaracter < 1  || valorCaracter > 2) {
            throw new IllegalAccessException("Valores fuera del rango");
            
        }else {
            if (valorCaracter == 1) {
                return "X";
            }else if (valorCaracter == 2){
                return "O";
            }
        }


        return null;
    }

    public boolean validaValorNumerico(int valorNumerico){

        if (valorNumerico > 0 && valorNumerico < 3) {
            return true;
        }

        return false;
    }
}
