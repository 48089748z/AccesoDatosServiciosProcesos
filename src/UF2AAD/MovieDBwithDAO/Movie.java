package UF2AAD.MovieDBwithDAO;
import java.util.ArrayList;
public class Movie
{
    private String movie_id;
    private String title;
    private String release_date;
    private ArrayList<Character> characters;

    public Movie(String movie_id, String title, String release_date, ArrayList<Character> characters)
    {
        this.movie_id=movie_id;
        this.title = title;
        this.release_date = release_date;
        this.characters=characters;
    }
    public Movie() {}
    public String getMovie_id() {return movie_id;}
    public void setMovie_id(String movie_id) {this.movie_id = movie_id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getRelease_date() {return release_date;}
    public void setRelease_date(String release_date) {this.release_date = release_date;}
    public ArrayList<Character> getCharacters() {return characters;}
    public void setCharacters(ArrayList<Character> characters) {this.characters = characters;}
    public String toString()
    {
        String allCharacters = "{";
        for(int x=0; x<characters.size(); x++)
        {
            allCharacters=allCharacters+characters.get(x).toString();
        }
        allCharacters=allCharacters+"}";
        return "\n\nMovie ID: "+movie_id+"\nTitle: "+title+"\nRelease Date: "+release_date+"\nCast: "+allCharacters;
    }
}
