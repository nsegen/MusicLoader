package me.nsegen.musicloader.services;

import me.nsegen.musicloader.entities.Track;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nsegen on 22.9.16.
 */
public class HTMLParserTest {

    private File file;
    private List<Track> tracks;

    @Before
    public void setUp() throws Exception {
        MusicListReader musicListReader = MusicListReader.getInstance();
        musicListReader.setPathToFile(Thread.currentThread().getContextClassLoader().getResource("test/testList.xml").getPath());
        musicListReader.read();
        tracks = musicListReader.getTrackList();
        file = new File(Thread.currentThread().getContextClassLoader().getResource("MusicHostsProperties.xml").getPath());
    }

    @Test
    public void getLinksToTracks() throws Exception {
        HTMLParser htmlParser = new HTMLParser(file);
        Map<Track, List<String>> result = htmlParser.getLinksToTracks(tracks);
        result.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

    }

    @Test
    public void getLinksToSingers() throws Exception {

    }

}