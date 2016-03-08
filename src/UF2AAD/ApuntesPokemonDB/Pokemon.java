package UF2AAD.ApuntesPokemonDB;

/**
 * Created by 48089748z on 12/11/15.
 */
public class Pokemon
{
    String name = null;
    String id = null;
    String types[] = null;

    public Pokemon(String name, String id, String[] types)
    {
        this.name = name;
        this.id = id;
        this.types=types;

    }
    public String[] getTypes() {
        return types;
    }
    public void setTypes(String[] tipos) {
        this.types = tipos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
