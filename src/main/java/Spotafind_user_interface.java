import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.util.*;

public class Spotafind_user_interface {
    private Scanner input = new Scanner(System.in);
    public String main_menu_prompt()
    {
        boolean validInput = false;
        String response = null;
        while( !validInput )
        {
            System.out.println("Choose an option:");
            System.out.println("1) Find a related song (doesn't work, sorry)");
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

    public int how_many_reqs()
    {
        boolean validInput = false;
        int response = -1;
        while (!validInput)
        {
            System.out.println("How many artist recomendations do you want? (type 1-20)");
            response = Integer.parseInt(input.nextLine());
            if(response>0&&response<21)
            {
                validInput = true;
            }
            else
            {
                System.out.println("Read the directions");
            }
        }
        return response;
    }
    public Artist[] right_artist_loop(SpotifeezioRequest req,Spotafind_user_interface ui)
    {
        Artist[] a = req.getArtistGuessList();
        int stepper = 0;
        boolean valid = false;
        while (!(valid))
        {
            System.out.println(a[stepper].getName() + " is this the artist you wanted?\n0 for yes 1 for no");
            //I need to iterate over the artist array in the get name area to see if the artist is in the list
            String right_artist = input.nextLine();
            while (!(right_artist.equals("0") || right_artist.equals("1")))
            {
                System.out.println("GIMME A 0 or 1!");
                right_artist = input.nextLine();
            }
            if (right_artist.equals("1"))
            {
                stepper+=1;
            }
            if (stepper > 10)
            {
                System.out.println("there is no artist in top 10");
                System.exit(0);
            }
            if (right_artist.equals("0"))
            {
                valid = true;
            }
        }

        return req.ArtistGetRelated(a[stepper]);
    }
}