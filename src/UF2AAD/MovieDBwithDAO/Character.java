package UF2AAD.MovieDBwithDAO;
public class Character
{
    String characterName;
    String actorName;
    String id;
    public Character(String characterName, String actorName, String id)
    {
        this.characterName=characterName;
        this.actorName=actorName;
        this.id=id;
    }
    public Character(){}
    public String getCharacterName() {return characterName;}
    public void setCharacterName(String characterName) {this.characterName = characterName;}
    public String getActorName() {return actorName;}
    public void setActorName(String actorName) {this.actorName = actorName;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String toString() {return "  [ID: "+id+" - Character: "+characterName+" - Actor: "+actorName+"]  ";}
}
