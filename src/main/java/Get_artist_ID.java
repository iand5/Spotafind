//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyApi.Builder;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

public class Get_artist_ID {
    private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
    private static final String q = "Abba";
    private static final SpotifyApi spotifyApi = (new Builder()).setAccessToken("taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk").build();
    private static final SearchArtistsRequest searchArtistsRequest;

    public static void searchArtists_Sync() {
        try {
            Paging<Artist> artistPaging = searchArtistsRequest.execute();
            Artist[] a = artistPaging.getItems();
            System.out.println(a[0].getId());
            System.out.println("Total: " + artistPaging.getTotal());
        } catch (SpotifyWebApiException | ParseException | IOException var1) {
            System.out.println("Error: " + var1.getMessage());
        }

    }

    public static void main(String[] args)
    {
        searchArtists_Sync();
    }

    static
    {
        searchArtistsRequest = spotifyApi.searchArtists(q).build();
    }
}
