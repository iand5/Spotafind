import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsRelatedArtistsRequest;
import java.io.IOException;
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

public class SpotifeezioRequest {
    private String name;
    private SpotifyApi spotifyApi;
    private String token;
    private static final String clientId = "ae9f63a21397483d83d8c48c1a9daf13";
    private static final String clientSecret = "b189cdcecc5a4a01936b78775d270832";
    private ClientCredentialsRequest clientCredentialsRequest;
    private SearchArtistsRequest searchArtistsRequest;

    public SpotifeezioRequest()
    {
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        String accessToken = getAccessToken();
        token = accessToken;
        spotifyApi.setAccessToken(accessToken);
    }

    private String getAccessToken()
    {
        String token = null;
        try
        {
            clientCredentialsRequest = spotifyApi.clientCredentials()
                    .build();
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            token = clientCredentials.getAccessToken();
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return token;
    }


    public String getName()
    {
        return name;
    }

    public String getToken()
    {
        return token;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Artist[] getRelated()
    {
        Artist[] artists = null;
        GetArtistsRelatedArtistsRequest artistsReq = spotifyApi
                .getArtistsRelatedArtists(name)
                .build();
        try
        {
            artists = artistsReq.execute();

            System.out.println("Length: " + artists.length);
            for(Artist a : artists)
            {
                System.out.println(a.getName());
            }
        }
        catch (IOException | SpotifyWebApiException | ParseException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return artists;
    }

    public void getArtistId()
    {
        searchArtistsRequest = spotifyApi.searchArtists(name).build();
        try {
            Paging<Artist> artistPaging = searchArtistsRequest.execute();
            Artist[] a = artistPaging.getItems();
            System.out.println("ID for" + name + ": " + a[0].getId());
            System.out.println("Number of pages of response: " + artistPaging.getTotal());
            //Here we switch from using the name for the name of the artist to using it for the artist ID string
            name = a[0].getId();
        } catch (SpotifyWebApiException | ParseException | IOException var1) {
            System.out.println("Error: " + var1.getMessage());
        }
    }

}
