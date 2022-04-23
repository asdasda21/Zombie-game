import java.util.*;

public class Principal {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Zombie> zombies = new ArrayList<>();
        ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println(
                    "Ingrese:\n0 si desea finalizar la ejecución del programa.\n1 si desea crear un zombie.\n2 si desea ver la información de todos los zombies creados.\n3 si desea ver la cantidad de zombies creados.\n4 si desea ver todos los zombies que tengan tipo de sangre 'O+' o 'AB+'.\n5 si desea ver la información de todos los zombies nacidos después del 20000.\n6 si desea disminuir a la mitad la salud de todos los zombies.\n7 si desea crear una ubicación.\n8 si desea ver la información de todas las ubicaciones creadas.\n9 si desea ver la ubicación más segura de la ciudad (aquella con el menor número de zombies).\n10 si desea ver la información de todas las ubicaciones de la ciudad ordenadas por distancia a Alexandria, de más cercana a más lejana.\n11 si desea ver una frase aleatoria sobre zombies.\n12 si desea ver el promedio de salud de los zombies.");
            int numero = sc.nextInt();

            if (numero == 0) {
                break;
            }

            else if (numero == 1) {
                System.out.println("Ingrese el nombre del zombie:");
                String nombre = sc.next();
                System.out.println("Ingrese la cantidad de salud del zombie:");
                int salud = sc.nextInt();
                System.out.println("Ingrese La fecha de nacimiento del zombie:");
                int[] fechaNacimiento = new int[3];
                System.out.print("Día: ");
                fechaNacimiento[0] = sc.nextInt();
                System.out.print("Mes: ");
                fechaNacimiento[1] = sc.nextInt();
                System.out.print("Año: ");
                fechaNacimiento[2] = sc.nextInt();
                System.out.println("El tipo de sangre del zombie:");
                String tipoSangre = sc.next();
                zombies.add(new Zombie(nombre, salud, fechaNacimiento, tipoSangre));
            }

            else if (numero == 2) {
                for (int i = 0; i < zombies.size(); i++) {
                    System.out.println(zombies.get(i).mostrarInformacion());
                }
            }

            else if (numero == 3) {
                System.out.println("Hasta el momento se han creado " + zombies.size() + " zombies.");
            }

            else if (numero == 4) {
                for (int i = 0; i < zombies.size(); i++) {
                    if (zombies.get(i).esOABPositivo()) {
                        System.out.println(zombies.get(i).mostrarInformacion());
                    }
                }
            }

            else if (numero == 5) {
                for (int i = 0; i < zombies.size(); i++) {
                    if (zombies.get(i).esNacidoDespuesDel2000()) {
                        System.out.println(zombies.get(i).mostrarInformacion());
                    }
                }
            }

            else if (numero == 6) {
                Zombie.reducirMitadSalud(zombies);
            }

            else if (numero == 7) {
                System.out.println("Ingrese el nombre de la ubicación:");
                String nombre = sc.next();
                System.out.println("Ingrese la distancia a Alexandria de la ubicación:");
                float distanciaAlexandria = sc.nextFloat();
                System.out.println("Ingrese la cantidad de zombies de la ubicación:");
                int cantidadZombies = sc.nextInt();
                ubicaciones.add(new Ubicacion(nombre, distanciaAlexandria, cantidadZombies));
            }

            else if (numero == 8) {
                for (int i = 0; i < ubicaciones.size(); i++) {
                    System.out.println(ubicaciones.get(i).mostrarInformacion());
                }
            }

            else if (numero == 9) {
                System.out.println(Ubicacion.masSegura(ubicaciones).mostrarInformacion());
            }

            else if (numero == 10) {
                for (int i = 0; i < ubicaciones.size(); i++) {
                    System.out.println(Ubicacion.ordenarUbicaciones(ubicaciones).get(i).mostrarInformacion());
                }
            }

            else if (numero == 11) {
                System.out.println(Zombie.frase());
            }

            else if (numero == 12) {
                System.out.println(Zombie.promedioSalud(zombies));
            }
        }
    }
}