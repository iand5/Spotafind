import se.michaelthelin.spotify.model_objects.specification.Artist;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;
public class Spotafind_driver
{
    public static void main(String[] args)
    {
        Spotafind_user_interface ui = new Spotafind_user_interface();
        boolean inloop_1 = true;
        while (inloop_1)
        {
            String mainResponse = ui.main_menu_prompt();
            if (mainResponse.equals("1"))
            {
                System.out.println("Songs chosen");
                //copy what is bellow but for songs
            }
            else if (mainResponse.equals("2"))
            {
                System.out.println("Artists chosen");
                Artist[] artist_list = Spotafind_artist_process.artist_request();
                int a = ui.how_many_reqs();
                for (int p = 0; p < a; p++)
                {
                    System.out.println(artist_list[p].getName());
                }
            }
            else
            {
                System.out.println("Bye");
                inloop_1 = false;
            }
        }
    }
}
