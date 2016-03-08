package UF2PSP.ExamenUF1OCunado.diposit;

public class Restador extends Thread
{
	private Diposit diposit;
	private int quantitat;
	public Restador(String nom, Diposit d, int q)
	{
		super(nom);
		diposit = d;
		quantitat = q;
	}
	public void run()
	{
		int index=0;
		while (index<5)
		{
			for (int i = 0; i < quantitat; i++)
			{
				if (diposit.decrementa(this)) //Si decrementa() devuelve true, significa que el deposito no esta vacio y podemos quitar mas.
				{
					System.out.println(getName() + " decrementa");
				}
				//Si decrementa() devuelve false, significa que el deposito esta vacio y no podemos quitar mas, por lo tanto hacemos que el Thread se espere 5segundos.
			}
			index++;
		}
	}
}

