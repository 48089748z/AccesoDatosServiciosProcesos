package UF2AAD.ExamenUF2;
public class Character
{

    private Integer id;
    private String name;
    private Integer num_episodis;
    private Integer[] episodes;

    public Character(Integer id, String name, Integer num_episodis, Integer[] episodes) {
        this.id = id;
        this.name = name;
        this.num_episodis = num_episodis;
        this.episodes = episodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num_episodis;
    }

    public void setNum(Integer num) {
        this.num_episodis = num;
    }

    public Integer[] getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer[] episodes) {
        this.episodes = episodes;
    }

    public void imprimir_personatge()
    {
        System.out.println("El personatge "+name+" te id "+id+".");
        for (int i = 0; i < num_episodis ; i++)
        {
            System.out.println("Episodi "+i+": id: "+episodes[i]);
        }
    }
    public String getEpisodesString()
    {
        String toReturn="";
        for (int i = 0; i < num_episodis ; i++)
        {
            toReturn=toReturn+"\nEpisodi "+i+": id: "+episodes[i];
        }
        return toReturn;
    }
}
