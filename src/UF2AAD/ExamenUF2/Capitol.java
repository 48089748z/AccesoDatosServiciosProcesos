package UF2AAD.ExamenUF2;
public class Capitol
{
    private Integer id;
    private String titol;
    private Integer num_pers;
    private Integer[] pers;
    private String[] name_pers;
    private String descripicio;

    public Capitol(Integer id, String titol, Integer num_pers, Integer[] pers, String[] name_pers, String descripicio) {
        this.id = id;
        this.titol = titol;
        this.num_pers = num_pers;
        this.pers = pers;
        this.name_pers = name_pers;
        this.descripicio = descripicio;
    }

    public String getDescripicio() {
        return descripicio;
    }

    public void setDescripicio(String descripicio) {
        this.descripicio = descripicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Integer getNum_pers() {
        return num_pers;
    }

    public void setNum_pers(Integer num_pers) {
        this.num_pers = num_pers;
    }

    public Integer[] getPers() {
        return pers;
    }

    public void setPers(Integer[] pers) {
        this.pers = pers;
    }

    public void imprimir_capitol(){
        System.out.println("Capitol "+ id+ " de titol "+titol+". Apareixen "+num_pers+" personatges.");
        for (int i = 0; i < num_pers ; i++) {
            System.out.println("Personatge: "+name_pers[i]+" te id: "+pers[i]);
        }
    }
   public String getPersString()
   {
       String toReturn="";
       for (int i = 0; i < num_pers ; i++)
       {
           toReturn=toReturn+"\nPersonatge: "+name_pers[i]+" te id: "+pers[i];
       }
       return toReturn;
   }
}
