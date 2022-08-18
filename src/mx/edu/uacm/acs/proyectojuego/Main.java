package mx.edu.uacm.acs.proyectojuego;
public class Main {
    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        Juego m=new Juego();
        try {
            m.menuPrincipal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
