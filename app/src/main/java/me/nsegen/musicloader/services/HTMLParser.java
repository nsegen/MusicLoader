package me.nsegen.musicloader.services;

import me.nsegen.musicloader.entities.ConnectionProperties;
import me.nsegen.musicloader.entities.Track;
import me.nsegen.musicloader.utils.SAXParserSitesPropertiesHandler;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 15.9.16.
 */
public class HTMLParser {

    private static final Logger log = Logger.getLogger(HTMLParser.class);

    private List<ConnectionProperties> connectionPropertiesList;

    public HTMLParser(File propertiesFile) throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXParserSitesPropertiesHandler SAXParserSitesPropertiesHandler = new SAXParserSitesPropertiesHandler();
            parser.parse(propertiesFile, SAXParserSitesPropertiesHandler);
            connectionPropertiesList = SAXParserSitesPropertiesHandler.getConnectionProperties();
        } catch (SAXException | ParserConfigurationException e) {

        }

    }

    private String getLinkToTrack(ConnectionProperties connectionProperties, Track track){
        String link = null;
        String searchRequest = connectionProperties.getSearchTemplate().replace("<<<singerName>>>", track.getSingerName());
        searchRequest = searchRequest.replace("<<<trackName>>>", track.getTrackName());
        searchRequest = connectionProperties.getHost() + searchRequest.replace(" ", "%20");

        try {
            Document page = Jsoup.connect(searchRequest)
                .cookies(connectionProperties.getCookies())
                .timeout(10000)
                .get();
            String searchQuery = connectionProperties.getTagName()+'.'+connectionProperties.getDownloadLinkClass().replace(' ', '.');
            Element linkTag = page.select(searchQuery).first();
            if(linkTag != null) {
                link = connectionProperties.getHost() + linkTag.attr(connectionProperties.getLinkAttribute());
            }
        } catch (IOException e) {
            log.warn(searchRequest + " is not found.");
        }
        return link;
    }

    public Map<Track, List<String>> getLinksToTracks(List<Track> tracks){
        Map<Track, List<String>> links = new HashMap<>();
        tracks.forEach(track -> {
            List<String> linksToTrack = new LinkedList<>();
            connectionPropertiesList.forEach(prop -> linksToTrack.add(getLinkToTrack(prop, track)));
            links.put(track, linksToTrack);
        });
        return links;
    }

    public List<String> getLinksToSingers(List<String> singers){
        List<String> links = new LinkedList<>();
        return links;
    }


}
