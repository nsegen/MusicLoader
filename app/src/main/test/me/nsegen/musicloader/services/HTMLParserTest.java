package me.nsegen.musicloader.services;

import me.nsegen.musicloader.services.HTMLParser;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void getLinksToSingers() throws Exception {

    }

}