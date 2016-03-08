package UF2PSP.ExamenUF1OCunado.diposit;

public class ProvaFil
{
	public static void main(String[] args)
	{
		Diposit deposit = new Diposit(10);
		Sumador Sumador1 = new Sumador("s1", deposit, 2);
		Sumador Sumador2 = new Sumador("s2", deposit, 5);
		Sumador Sumador3 = new Sumador("s3", deposit, 3);
		Restador Restador1 = new Restador("r1", deposit, 6);
		Restador Restador2 = new Restador("r2", deposit, 4);

		Sumador1.start();
		Sumador2.start();
		Sumador3.start();
		Restador1.start();
		Restador2.start();
	}
}
