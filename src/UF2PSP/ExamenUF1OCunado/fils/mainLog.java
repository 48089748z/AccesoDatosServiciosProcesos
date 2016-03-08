package UF2PSP.ExamenUF1OCunado.fils;
public class mainLog
{
    public static Recerca[] arrayThreads = new Recerca[10];
    public static Double arrayNumeros[] = new Double[10000];
    public static int number = 0;
    public static void main(String[] args)
    {
        llenarArrayThreads(); //Esta funcion solamente nos genera 10 Threads de tipo "Recerca".
        calcularLogsConThreads(); //Esta funcion ejecutara estos 10 Threads para que cada uno de ellos calcule solamente 1000/10000 Math.logs
    }
    public static void calcularLogsConThreads()
    {
        for (int x=0; x<10; x++)
        {
            for (int y=0; y<1000; y++)
            {
                arrayThreads[x].run();
                System.out.println("  Thread " + String.valueOf(x + 1) + " ha calculat el logaritme Nº " + number + " y l'ha guardat a un array");
                arrayThreads[x].imprimir();
                number++;
            }
        }
    }
    public static void llenarArrayThreads()
    {
        for (int x=0; x<10; x++)
        {
            arrayThreads[x] = new Recerca();
        }
    }
    public static Double getLog()
    {
       return  Math.log(number);
    }
}
