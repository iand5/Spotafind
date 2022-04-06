import se.michaelthelin.spotify.model_objects.specification.Artist;
import java.util.*;

public class Spotifeezio {
    public static void main(String[] args) {
        SpotifeezioRequest req = new SpotifeezioRequest();
        Scanner in =  new Scanner(System.in);
        //get artist name
        System.out.println("Gimme Da Name:");
        String datName = in.nextLine();
        //req.setName(datName);
        req.setName(datName);
        req.getArtistId();
        Artist[] relatedArtists = req.getRelated();
    }
}
