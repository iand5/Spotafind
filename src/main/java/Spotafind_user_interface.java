import se.michaelthelin.spotify.model_objects.specification.Artist;

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
}