package UF2PSP.ExamenUF1OCunado.diposit;
public class Diposit
{
	private Integer maxim;
	private Integer quant;
	public Diposit(Integer max)
	{
		maxim = max;
		quant = 0;
	}
	public synchronized boolean incrementa(Sumador sumador) //Modificado el metodo incrementa para que devuelva boolean.
	{
		if (quant != maxim)
		{
			notifyAll();
			quant++;
			System.out.println("\nDiposit esta a: " + quant + "/10");
			return true;
		}
		else
		{
			System.out.println("\nDiposit esta ple:  Sumador en estat de wait()");
			try {sumador.wait();}
			catch (InterruptedException e) {}
			return false;
		}
	}
	public synchronized boolean decrementa(Restador restador)  //Modificado el metodo decrementa para que devuelva boolean.
	{
		if (quant != 0)
		{
			notifyAll();
			quant--;
			System.out.println("\nDiposit esta a: " + quant + "/10");
			return true;
		}
		else
		{
			System.out.println("\nDiposit esta buit:  Restador en estat de wait()");
			try {restador.wait();}
			catch (InterruptedException e) {}
			return false;
		}
	}
}
