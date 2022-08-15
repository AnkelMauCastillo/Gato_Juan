package mx.edu.uacm.acs.proyectojuego;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private int opcion;
    private String simbolo[]=new String[2];

    private Jugador jugadorUno = new Jugador();
    private Jugador jugadorDos = new Jugador();

    private ArrayList<Jugador> jugadores;

    public Juego() {
        
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
  
    
    Scanner entrada=new Scanner(System.in);

    public void menuPrincipal() throws InterruptedException {
        int opc;
        String nombre="";
        
        do{
            System.out.println("\t#Juego del GATO#");
            System.out.println("1.Humano vs Humano");
            System.out.println("2.Salir");
            System.out.println("Selecciona una opcion[1-2]: ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                        Movimientos();

                    break;
                case 2:
                    System.out.println("Salio del Juego.\nVuelva pronto...");
                    break;               
                default: System.out.println("Opcion no valida.\nIntentelo de nuevo...\n\n");
            }
        }while(this.opcion!=2);
    }
    
    public String escogeSigno(int opcion){
        if(opcion==1){
            return simbolo[0]="X";
        }else{
            return simbolo[1]="O";
        }
    }
    public void Movimientos() throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        int turno=0;
        int posicion;
        int bandera=1;
        boolean gana=false;
        boolean validaCeldaOcupada = true;
        jugadores = ImprimeNombreArraySimbolosYNombre();
        System.out.println("ID: "+ (jugadores.size()-1) +" " +jugadores.get(0).getNombre()+"  juega con el simbolo: "+ jugadores.get(0).getSimbolo());
        System.out.println("ID: "+ (jugadores.size())+  " " + jugadores.get(1).getNombre()+"  juega con el simbolo: "+ jugadores.get(1).getSimbolo());
        Tablero t=new Tablero();
        t.iniciaJuego(jugadores.get(0), jugadores.get(1));

    }




    public String asignaNombreJugadores(Jugador jugador, int posicion){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre Jugador: " + (posicion + 1));
        String nombre = entrada.nextLine();
        return nombre;
    }
    public ArrayList<Jugador> ImprimeNombreArraySimbolosYNombre(){
        Juego juego = new Juego();

        ArrayList<Jugador> jugadores1 = new ArrayList<>();
        jugadores1.add(jugadorUno);
        jugadores1.add(jugadorDos);

        for (int i = 0; i < jugadores1.size(); i++) {
            String nombre = juego.asignaNombreJugadores(jugadores1.get(i),i);
            jugadores1.get(i).setNombre(nombre);
            jugadores1.get(i).setSimbolo(jugadores1.get(i).assignaCaracter(i + 1));

        }


        return jugadores1;


    }
    
}
