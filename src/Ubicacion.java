import java.util.*;

public class Ubicacion {
    private String nombre;
    private float distanciaAlexandria;
    private int cantidadZombies;

    public Ubicacion(String nombre, float distancia, int cantidadZombies) {
        this.nombre = nombre;
        this.distanciaAlexandria = distancia;
        this.cantidadZombies = cantidadZombies;
    }

    public float getDistanciaAlexandria() {
        return this.distanciaAlexandria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidadZombies() {
        return cantidadZombies;
    }

    public String mostrarInformacion() {
        String mensaje = "La ubicacion " + getNombre() + " está a " + getDistanciaAlexandria()
                + " metros de Alexandria y tiene " + getCantidadZombies() + " zombies.";
        return mensaje;
    }

    public static Ubicacion masSegura(ArrayList<Ubicacion> ubicaciones) {
        Ubicacion masSegura = ubicaciones.get(0);
        for (int i = 1; i < ubicaciones.size(); i++) {
            if (ubicaciones.get(i).getCantidadZombies() < masSegura.getCantidadZombies()) {
                masSegura = ubicaciones.get(i);
            }
        }
        return masSegura;
    }

    public static ArrayList<Ubicacion> ordenarUbicaciones(ArrayList<Ubicacion> ubicaciones) {
        Ubicacion temp;
        for (int i = 0; i < ubicaciones.size() - 1; i++) {
            for (int j = 0; j < ubicaciones.size() - i - 1; j++) {
                if ((ubicaciones.get(j).getDistanciaAlexandria()) > (ubicaciones.get(j + 1).getDistanciaAlexandria())) {
                    temp = ubicaciones.get(j);
                    ubicaciones.set(j, ubicaciones.get(j + 1));
                    ubicaciones.set(j + 1, temp);
                }
            }
        }
        return ubicaciones;
    }
}