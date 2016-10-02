package me.nsegen.musicloader.utils;

import me.nsegen.musicloader.entities.Track;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nsegen on 2.10.16.
 */
public class SAXParserListOfTracksHandler extends DefaultHandler {

    private static final Logger log = Logger.getLogger(SAXParserSitesPropertiesHandler.class);

    private List<Track> tracks;
    private List<String> singersWithAllTracks;
    private String currentSinger;

    public SAXParserListOfTracksHandler(){
        tracks = new LinkedList<>();
        singersWithAllTracks = new LinkedList<>();
    }

    public List<Track> getTracks(){
        return new LinkedList<>(tracks);
    }

    public List<String> getSingersWithAllTracks() {
        return new LinkedList<>(singersWithAllTracks);
    }

    @Override
    public void startDocument() throws SAXException {
        tracks = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "singer":
                currentSinger = attributes.getValue("name");
                if(attributes.getValue("isAll") != null && attributes.getValue("isAll").equals("true")){
                    singersWithAllTracks.add(currentSinger);
                }
                break;
            case "track":
                Track track = new Track();
                track.setSingerName(currentSinger);
                track.setTrackName(attributes.getValue("name"));
                tracks.add(track);
                break;
        }
    }
}
