import java.util.ArrayList;

public class Zombie {
    private String nombre;
    private int salud;
    private int[] fechaNacimiento;
    private String tipoSangre;

    public Zombie(String nombre, int salud, int[] fechaNacimiento, String tipoSangre) {
        this.nombre = nombre;
        this.salud = salud;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getSalud() {
        return this.salud;
    }

    public int[] getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public String getTipoSangre() {
        return this.tipoSangre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String mostrarInformacion() {
        String mensaje = "El zombie " + getNombre() + " tiene una salud de " + getSalud() + ", nació el "
                + getFechaNacimiento()[0] + "/" + getFechaNacimiento()[1] + "/" + getFechaNacimiento()[2]
                + " y tiene sangre tipo " + getTipoSangre() + ".";
        return mensaje;
    }

    public boolean esOABPositivo() {
        return getTipoSangre().equalsIgnoreCase("O+") || getTipoSangre().equalsIgnoreCase("AB+");
    }

    public boolean esNacidoDespuesDel2000() {
        return getFechaNacimiento()[2] > 2000;
    }

    public static void reducirMitadSalud(ArrayList<Zombie> zombies) {
        for (Zombie zombie : zombies) {
            zombie.setSalud(zombie.getSalud() / 2);
        }
    }

    public static String frase() {
        String[] frases = { "Viven para la noche, viven para matar, y ... viven siempre.",
                "Hay que valorar los zombies porque no te quieren por tu físico sino por tu cerebro.",
                "Cuando no quede más sitio en el infierno los muertos caminaran sobre la tierra.",
                "Ejércitate, porque los zombies se comerán el más lento", "Estoy listo para el apocalipsis" };
        int random = (int) (Math.random() * (5));
        return frases[random];
    }

    public static String promedioSalud(ArrayList<Zombie> zombies) {
        int suma = 0;
        for (Zombie zombie : zombies) {
            suma += zombie.getSalud();
        }
        double promedio = suma / zombies.size();
        return "El promedio de salud de los zombies creados es: " + promedio;
    }
}