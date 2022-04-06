public class Spotafind_driver {
    public static void main(String[] args) {
        Spotafind_user_interface ui = new Spotafind_user_interface();

        boolean inloop_1 = true;
        while(inloop_1)
        {
            String mainResponse = ui.main_menu_prompt();
            if (mainResponse.equals("1"))
            {
                System.out.println("Songs chosen");
                if (song_req_path(ui))
                {
                    System.out.println("Bye");
                    inloop_1 = false;
                }
            }
            else if (mainResponse.equals("2"))
            {
                System.out.println("Artists chosen");
                if (artist_req_path(ui))
                {
                    System.out.println("Bye");
                    inloop_1 = false;
                }
            }
            else
            {
                System.out.println("Bye");
                inloop_1 = false;
            }
        }
    }

    private static boolean song_req_path(Spotafind_user_interface ui)
    {
        boolean yes_quit = false;
        String[] song_response = ui.give_me_da_song();
        if (song_response==null)
        {
            yes_quit = true;
        }
        else
        {
            for(String song: song_response)
            {
                System.out.println(song);
            }
        }
        return yes_quit;
    }
    private static boolean artist_req_path(Spotafind_user_interface ui)
    {
        boolean yes_quit = false;
        String[] artist_response = ui.give_me_da_artist();
        if (artist_response==null)
        {
            yes_quit = true;
        }
        else
        {
            for(String artist: artist_response)
            {
                System.out.println(artist);
            }
        }
        return yes_quit;
    }
}
