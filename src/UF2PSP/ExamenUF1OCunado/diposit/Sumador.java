package UF2PSP.ExamenUF1OCunado.diposit;
public class Sumador extends Thread {

	private Diposit diposit;
	private int quantitat;
	
	public Sumador(String nom, Diposit d, int q)
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
                if (diposit.incrementa(this)) //Si incrementa() devuelve true, significa que el deposito no esta lleno y podemos añadir mas.
                {
                    System.out.println(getName() + " incrementa");
                }
                //Si incrementa() devuelve false, significa que el deposito esta lleno y no podemos añadir mas, por lo tanto hacemos que el Thread se espere 5segundos.
            }
            index++;
		}
	}
}
