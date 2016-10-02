package me.nsegen.musicloader.utils;

import me.nsegen.musicloader.entities.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nsegen on 2.10.16.
 */
public class SAXParserListOfTracksHandlerTest {

    private SAXParserFactory factory;
    private SAXParser parser;
    private SAXParserListOfTracksHandler saxParserListOfTracksHandler;
    private File file;

    @Before
    public void setUp() throws Exception {
        factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        saxParserListOfTracksHandler = new SAXParserListOfTracksHandler();
        file = new File(Thread.currentThread().getContextClassLoader().getResource("test/testList.xml").getPath());
        parser.parse(file, saxParserListOfTracksHandler);

    }

    @Test
    public void getTracks() throws Exception {
        List<Track> expectedTracks = new ArrayList<>();
        Track tmp = new Track();
        tmp.setSingerName("Rammstein");
        tmp.setTrackName("Rosenrot");
        expectedTracks.add(tmp);
        tmp = new Track();
        tmp.setSingerName("Rammstein");
        tmp.setTrackName("Main Land");
        expectedTracks.add(tmp);
        List<Track> tracks = saxParserListOfTracksHandler.getTracks();
        Assert.assertEquals(expectedTracks, tracks);

    }

    @Test
    public void getSingersWithAllTracks() throws Exception {
        List<String> singers = saxParserListOfTracksHandler.getSingersWithAllTracks();

        Assert.assertEquals("БИ-2", singers.get(0));
    }

}