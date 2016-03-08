package UF2PSP.SuperMarket;

import java.util.Scanner;

/**
 * Created by 48089748z on 04/11/15.
 */
public class ModernSuperMarket extends Client
{
    private static Scanner in = new Scanner(System.in);
    private static long tiempoTotal;
    private static long recaudacionTotal;

    public static void main(String[] args) //Aqui els clients van entrant i sortint, pasen un temps aleatori dins del supermercat i van a cualsevol caixa, esperant a que acabi si hi ha algú a aquella caixa
    {
        System.out.println("\n-------------------------------------\n|Welcome to the Modern SuperMarket |\n|   Cuantos clientes quieres?      |");
        int numClients = in.nextInt();
        System.out.println("|   Cuantas cajas quieres?         |");
        int numCajas = in.nextInt();
        System.out.println("-------------------------------------\n|    SUPERMARKET IS RUNNING        |\n------------------------------------------------------------------------------------------------");

        for (int x=1; x<=numClients; x++)
        {
            int randomCaja = 1 + (int)(Math.random()*numCajas);
            Client client = new Client();
            System.out.println("\nCliente "+x+" Waiting...");
            client.run();
            System.out.println("Cliente " + x + " ha pasado " + client.calcMiliSegonsTranscorreguts() + " milisegundos en el supermercado, ha ido a la Caja " + randomCaja + " y ha pagado " + client.calcMiliSegonsTranscorreguts() / 100 + "€");
            tiempoTotal = tiempoTotal + client.calcMiliSegonsTranscorreguts();
            recaudacionTotal = recaudacionTotal + client.calcMiliSegonsTranscorreguts() / 100;
        }
        System.out.println("------------------------------------------------------------------------------------------------\n\n------------------------------------");
        System.out.println("| Tiempo Medio: "+tiempoTotal/numClients+" milisegundos  |");
        System.out.println("|     Recaudación Total: "+recaudacionTotal+"€      |\n------------------------------------");
    }
}
