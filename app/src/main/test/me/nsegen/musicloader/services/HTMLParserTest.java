package me.nsegen.musicloader.services;

import me.nsegen.musicloader.services.HTMLParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            doc = Jsoup.connect("http://zf.fm/mp3/search?keywords=rammstein%20rosenrot").get();
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