package me.nsegen.musicloader.services;

import me.nsegen.musicloader.entities.Track;
import me.nsegen.musicloader.utils.SAXParserListOfTracksHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 15.9.16.
 */
public class MusicListReader {

    private static final Logger log = Logger.getLogger(MusicListReader.class);

    private String pathToFile;

    private List<Track> trackList;
    private List<String> singerList;

    private SAXParserFactory factory;
    private SAXParser parser;
    private SAXParserListOfTracksHandler saxParserListOfTracksHandler;

    private static MusicListReader musicListReader;


    private MusicListReader() {
        pathToFile = "";
        trackList = new LinkedList<>();
        singerList = new LinkedList<>();
        factory = SAXParserFactory.newInstance();
    }

    public static MusicListReader getInstance() {
        if(musicListReader == null){
            musicListReader = new MusicListReader();
        }
        return musicListReader;
    }

    public void read() throws IOException, SAXException {

        try {
            parser = factory.newSAXParser();
            saxParserListOfTracksHandler = new SAXParserListOfTracksHandler();
            parser.parse(new File(pathToFile), saxParserListOfTracksHandler);
            trackList = saxParserListOfTracksHandler.getTracks();
            singerList = saxParserListOfTracksHandler.getSingersWithAllTracks();
        } catch (ParserConfigurationException e) {

        }

    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<Track> getTrackList() {
        return new LinkedList<>(trackList);
    }

    public List<String> getSingerList() {
        return new LinkedList<>(singerList);
    }
}
