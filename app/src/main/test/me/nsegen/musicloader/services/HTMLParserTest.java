package me.nsegen.musicloader.services;

import me.nsegen.musicloader.services.HTMLParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import sun.net.www.http.HttpClient;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by nsegen on 22.9.16.
 */
public class HTMLParserTest {

    private List<String> tracks;

    @Before
    public void setUp() {
        tracks = new ArrayList<>();
        tracks.add("Rammstein Rosenrot");
        tracks.add("Rammstein Main land");
    }

    @Test
    public void getLinksToTracks() throws Exception {
        HTMLParser htmlParser = new HTMLParser();
        List<String> result = htmlParser.getLinksToTracks(tracks);
        result.forEach(System.out::println);

        Document doc = null;
        try {//            httpClient.
//            Map<String, String> cookies = new HashMap<>();
//            cookies.put("last_visit", "1474900413993::1474911213993");
//            cookies.put("ZvcurrentVolume", "100");
//            cookies.put("PHPSESSID", "kkkk9ojabfbohog9q9bhsko2n4");
//            cookies.put("zvAuth", "1");
//            cookies.put("zvLang", "0");
//            URL url = new URL("http://www.zv.fm");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.connect();
//            List<String> cookiesList = con.getHeaderFields().get("Set-Cookie");
//            Map<String, String> cookies = new HashMap<>();
//            map.forEach((key, value) -> cookies.put(key, value.toString().replace("[", "").replace("]", "")));
            //String cookie = con.getHeaderField("Set-Cookie");
            doc = Jsoup.connect("http://zf.fm/mp3/search?keywords=rammstein%20rosenrot")
                    //.userAgent("Ubuntu Chromium/52.0.2743.116")
                    //.cookie("last_visit", "1474900441086::1474911241086")
                    //.cookie("ZvcurrentVolume", "100")
                    //.cookie("PHPSESSID", "kkkk9ojabfbohog9q9bhsko2n4")
                    .cookie("zvAuth", "1")
                    //.cookie("zvLang", "0")
                    //.cookie("_ym_uid", "1474911055698148053")
                    //.cookie("_ym_isad", "1")
                    //.cookie("notice", "11")
                    //.cookie("_ga", "GA1.2.155656012.1474911055")
                    //.cookie("_ga", "GA1.2.155656012.1474911055")
                    //.cookie(cookies.get("Set-Cookie"))
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        System.out.println(title);

    }

    @Test
    public void getLinksToSingers() throws Exception {

    }

}