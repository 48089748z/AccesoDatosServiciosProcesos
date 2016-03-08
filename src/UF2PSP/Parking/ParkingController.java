package UF2PSP.Parking;
import java.util.Scanner;

public class ParkingController
{
    public static Scanner in = new Scanner(System.in);
    public static boolean[] spots; //Array de booleans, nos dice si coche X esta en el Parking (true) o esta fuera (false)
    public static CarThread[] carThreads; //Array de threads
    public static Integer times;

    public static void main(String[] args)
    {
        questions();
        generateThreads();
    }
    public static void questions()
    {
        System.out.println("\n¿Cuantas plazas quieres que tenga el Parking?");
        Integer numSlots = in.nextInt();

        System.out.println("\n¿Cuantos coches quieres que participen en el Test?");
        Integer numCars = in.nextInt();

        System.out.println("\n¿Cuantas veces quieres que cada coche entre y salga del Parking?\n(Recomiendo menos de 5, si no tardará mucho en acabar el programa)");
        times = in.nextInt();

        spots = new boolean[numSlots+1];
        carThreads = new CarThread[numCars];
    }
    public static void generateThreads()
    {
        for (int x=0; x< carThreads.length ; x++) //Creamos el numero de threads que ha pedido el usuario por pantalla.
        {
            carThreads[x] = new CarThread(times, x); //Usarmos la X como ID del coche para que no se repita ninguna.
            carThreads[x].start();
        }
    }
}
