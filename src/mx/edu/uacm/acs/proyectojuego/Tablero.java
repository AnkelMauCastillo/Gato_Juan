package mx.edu.uacm.acs.proyectojuego;

import java.util.Scanner;

public class Tablero {

    private static final int COLUMNAS = 3;
    private static final  int FILAS = 3;
    private  String [][] tablero = new String[COLUMNAS][FILAS];
    private int [][] tabla = new int[COLUMNAS][FILAS];

    //Cronstruimos el tablero(inicializamos)
    public Tablero() {
        int contador = 1;
        for(int i=0; i< COLUMNAS; i++){
            for(int j=0; j< FILAS; j++){
                tablero[i][j] = " ";
            }
        }

        for(int i=0; i< COLUMNAS; i++){
            for(int j=0; j< FILAS; j++){
                tabla[i][j] = contador;
                contador++;
            }
        }
    }

    public int[][] getTabla() {
        return tabla;
    }

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
    Scanner entrada=new Scanner(System.in);
    

    public void imprimirTablero(){
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(tabla[i][j]+"|");
                
            }
            System.out.println("");
        }
        System.out.println("");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(tablero[i][j]+"|");
                
            }
            System.out.println("");
        }
    }
    
    public void iniciaJuego(Jugador p1, Jugador p2) throws InterruptedException{
        
        int turno=0;
        int posicion;
        int bandera=1;
        boolean gana=false;
        boolean validaCeldaOcupada = true;

        System.out.println("Que gane el Mejor :D\n");
        do{
            turno++;
            imprimirTablero();
            System.out.println("\n");
            
            if(turno%2==1){
                do{
                    validaCeldaOcupada=juega(p1);
                }while (validaCeldaOcupada != false);
                
            }else{
                validaCeldaOcupada = true;
                do{
                    validaCeldaOcupada=juega(p2);       
                }while (validaCeldaOcupada != false);
                
            }
            
        }while(ganador(p1,p2)==false && empate(turno)==false);

        System.out.println(tablero);
        //pausa
        Thread.sleep(5000);

    }
    
    public boolean estaVacia(int posicion, Jugador p){
        int cuentaPosicion=1;
        boolean valida=false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tablero[i][j]== " " && posicion==cuentaPosicion){
                    tablero[i][j]=p.getSimbolo();
                    valida=true;                 
                }
                cuentaPosicion++;
            }
         }
        return valida;
    }

    public boolean ganador(Jugador p1, Jugador p2){
        boolean n=false;
        for (int i = 0; i < 9; i++){
            String linea = " ";
            switch (i) {
                case 1 :
                    linea = String.valueOf(tablero[0][0]) +
                            String.valueOf(tablero[0][1]) +
                            String.valueOf(tablero[0][2]);
                    break;
                case 2 :
                    linea = String.valueOf(tablero[0][0]) +
                            String.valueOf(tablero[1][1]) +
                            String.valueOf(tablero[2][2]);
                    break;

                case 3 :
                    linea = String.valueOf(tablero[0][0]) +
                            String.valueOf(tablero[1][0]) +
                            String.valueOf(tablero[2][0]);
                    break;

                case 4 :
                    linea = String.valueOf(tablero[0][1]) +
                            String.valueOf(tablero[1][1]) +
                            String.valueOf(tablero[2][1]);
                    break;

                case 5 :
                    linea = String.valueOf(tablero[0][2]) +
                            String.valueOf(tablero[1][2]) +
                            String.valueOf(tablero[2][2]);
                    break;

                case 6 :
                    linea = String.valueOf(tablero[1][0]) +
                            String.valueOf(tablero[1][1]) +
                            String.valueOf(tablero[1][2]);
                    break;

                case 7 :
                    linea = String.valueOf(tablero[2][0]) +
                            String.valueOf(tablero[2][1]) +
                            String.valueOf(tablero[2][2]);
                    break;
                case 8 :
                    linea = String.valueOf(tablero[0][2]) +
                            String.valueOf(tablero[1][1]) +
                            String.valueOf(tablero[2][0]);


                    break;
                default:
                    linea = "1";
                    break;
            }

            if (linea.equals("XXX")){
                if(p1.getSimbolo()=="X"){
                    System.out.println(p1.getNombre()+" Gano. FELICIDADES");
                }else{
                    System.out.println(p2.getNombre()+" Gano. FELICIDADES");
                }
                return n=true;
            }
            else if (linea.equals("OOO")){
                if(p1.getSimbolo()=="O"){
                    System.out.println(p1.getNombre()+" Gano. FELICIDADES");
                }else{
                    System.out.println(p2.getNombre()+" Gano. FELICIDADES");
                }
                return n=true;
            }

        }
        return n;
    }
    
    public boolean juega(Jugador p){
        int posicion;
        System.out.println(p.getNombre()+" es tu turno:");
        System.out.print("Cual es tu posicion: ");
        posicion=entrada.nextInt();
        entrada.nextLine();
        if(estaVacia(posicion,p)==true){
            System.out.println("Posicion colocada");
            return false;
        }else{
            System.out.println("Posicion no encontrada\nIntentelo de nuevo...");
            return true;
        }
    }
    
    public boolean empate(int turno){
        if(turno>8){
            System.out.println("Empate");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tablero:\n"+ "|"+tablero [0][0] + "|" + tablero [0][1] + "|" + tablero [0][2] +"|" +"\n" +
                             "|"+tablero [1][0] + "|" + tablero [1][1] + "|" + tablero [1][2] +"|" +"\n" +
                             "|"+tablero [2][0] + "|" + tablero [2][1] + "|" + tablero [2][2] +"|";
    }
    
    
    
}
