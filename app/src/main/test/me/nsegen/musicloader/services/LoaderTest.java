package me.nsegen.musicloader.services;

import me.nsegen.musicloader.entities.Track;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by segen on 03.10.2016.
 */
public class LoaderTest {
    @Before
    public void setUp() throws Exception {

        MusicListReader musicListReader = MusicListReader.getInstance();
        musicListReader.setPathToFile(Thread.currentThread().getContextClassLoader().getResource("test/testList.xml").getPath());
        musicListReader.read();
        List<Track> tracks = musicListReader.getTrackList();
        HTMLParser parser = new HTMLParser(new File(Thread.currentThread().getContextClassLoader().getResource("MusicHostsProperties.xml").getPath()));
        Map<Track, List<String>> linksToTracks = parser.getLinksToTracks(tracks);
        Loader loader = Loader.getInstance();
        loader.setResultDirectory("/home/nsegen/Музыка");
        loader.downloadTracks(linksToTracks);

    }

    @Test
    public void downloadTracks() throws Exception {

    }

}