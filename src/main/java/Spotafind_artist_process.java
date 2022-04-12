import se.michaelthelin.spotify.model_objects.specification.Artist;
import java.util.Scanner;

public class Spotafind_artist_process
{
    public static Artist[] artist_request()
    {
        SpotifeezioRequest req = new SpotifeezioRequest();
        Scanner in =  new Scanner(System.in);
        //get artist name
        System.out.println("Gimme Da Name:");
        String datName = in.nextLine();
        //req.setName(datName);
        req.setName(datName);
        req.getArtistId();
        Artist[] poop = req.getRelated();
        return poop;
    }
}
//move to UI