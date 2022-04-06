import java.util.*;

public class Spotafind_user_interface {
    private Scanner input = new Scanner(System.in);
    public String main_menu_prompt()
    {
        boolean validInput = false;
        String response = null;
        while( !validInput ) {
            System.out.println("Choose an option:");
            System.out.println("1) Find a related song");
            System.out.println("2) Find a related artist");
            System.out.println("Q) Quit");
            response = input.nextLine().toUpperCase();
            if( response.equals("1") || response.equals("2") || response.equals("Q"))
            {
                validInput = true;
            }
            else
            {
                System.out.println("Chose either 1,2,or Q");
            }
        }
        return response;
    }

    public String[] give_me_da_song()
    {
        boolean validInput = false;
        String response = null;
        String[] songs_list = null;
        while (!validInput)
        {
            System.out.println("Give me the song's name, or Q");
            response = input.nextLine().toLowerCase();
            if (response.equals("q"))
            {
                break;
            }
            songs_list = Spotafind_song_request.song_request(response);
            if(songs_list.equals(null))
            {
                System.out.println("null response, Spotify does not know this song");
            }
            else
            {
                validInput = true;
            }
        }
        return songs_list;
    }

    public String[] give_me_da_artist()
    {
        boolean validInput = false;
        String response = null;
        String[] artist_list = null;
        while (!validInput)
        {
            System.out.println("Give me the artist's name, or Q");
            response = input.nextLine().toLowerCase();
            if (response.equals("q"))
            {
                break;
            }
            artist_list = Spotafind_artist_request.artist_request(response);
            if(artist_list.equals(null))
            {
                System.out.println("null response, Spotify does not know this artist");
            }
            else
            {
                validInput = true;
            }
        }
        return artist_list;
    }
}