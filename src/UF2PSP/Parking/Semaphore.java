package UF2PSP.Parking;
import static java.lang.Thread.sleep;
public class Semaphore
{
    public synchronized void stayXTime()
    {
        int random = 1000 + (int)(Math.random()*10000);
        try {sleep(random);}
        catch (InterruptedException one){}
    }
    public synchronized int enterCar()
    {
        while (freeSlots() == 0)
        {
            try {wait();}
            catch (InterruptedException e) {}
        }
        return giveSlot();
    }
    public synchronized void exit(CarThread car)
    {
        ParkingController.spots[car.saleCoche()] = false;
        notifyAll();
    }
    public static int freeSlots()
    {
        Integer cont=0;
        for (boolean slot: ParkingController.spots)
        {
            if (slot == false)
            {
                cont++;
            }
        }
        return cont;
    }
    public int giveSlot()
    {
        Integer cont = 0;
        for (boolean spot: ParkingController.spots)
        {
            if (spot == true) {cont++;}
            else {break;}
        }
        ParkingController.spots[cont] = true;
        return cont;
    }
}