package UF2PSP.Parking;

public class CarThread extends Thread
{
    Semaphore semaphore = new Semaphore();
    boolean insideParking = false;
    Integer id;
    Integer slot;
    Integer times;
    public CarThread(Integer times, Integer id)
    {
        this.id = id;
        this.times=times;
    }
    public final void run()
    {
        while (times > 0)
        {
            entraCoche(semaphore.enterCar());
            semaphore.stayXTime();
            semaphore.exit(this);
            semaphore.stayXTime();
            times--;
        }
    }
    public void entraCoche(int slot)
    {
        System.out.println("Coche con ID: "+id+" ha ENTRADO en la plaza "+slot);
        this.slot = slot;
        insideParking = true;
    }
    public int saleCoche()
    {
        System.out.println("Coche con ID: "+id+" ha SALIDO de la plaza "+slot);
        insideParking = false;
        return slot;
    }
}
