package UF1AAD.Animals; /**
 * Created by 48089748z on 29/09/15.
 */

public class animal //Objecte animal
{
    private String nom; //Nom del Animal
    private String codi; //Codi EX EW CR EN VU NT LC

    public animal (String nom, String codi) //Constructor del Objecte Animal, ens demanara sempre un nom i un codi.
    {
        this.nom=nom;
        this.codi=codi;
    }
    //Getters i setters, que en el nostre cas no son necesaris perque utilitzem directament el toString()
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    @Override
    public String toString()
    {
        return  "Animal{" + "Nom='" + nom + '\'' + ", Codi='" + codi + '\'' + '}';
    }
}
