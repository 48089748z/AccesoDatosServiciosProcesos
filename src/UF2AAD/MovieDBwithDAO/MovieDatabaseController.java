package UF2AAD.MovieDBwithDAO;
import java.util.Scanner;
public class MovieDatabaseController
{
    private static Scanner in = new Scanner(System.in);;
    public static MovieDAO DAO;

    public static void main(String[] args)
    {
        DAO = new MovieDAO();
        boolean stop = false;
        while (!stop)
        {
            System.out.println("\n1: Show all Movies & Actors\n2: Search Films by Film ID\n3: Search Films by Actor ID\nElse: Exit");
            String option = in.nextLine();
            switch (option)
            {
                case "1":
                {
                    DAO.showAll();
                    break;
                }
                case "2":
                {
                    System.out.println("\nWrite the Film ID");
                    int filmId = in.nextInt();
                    DAO.searchFilm(filmId);
                    break;
                }
                case "3":
                {
                    System.out.println("\nWrite the Actor ID to see the Films he appears in");
                    int actorId = in.nextInt();
                    DAO.searchFilmByActor(actorId);
                    break;
                }
                default:
                {
                    stop = true;
                    break;
                }
            }
        }
    }
}