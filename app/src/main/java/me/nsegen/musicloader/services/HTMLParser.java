package me.nsegen.musicloader.services;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 15.9.16.
 */
public class HTMLParser {

    private static final Logger log = Logger.getLogger(HTMLParser.class);

    private String searchURLTemplate = "http://mixpromo.net/search/";

    public List<String> getLinksToTracks(List<String> tracks){
        List<String> links = new LinkedList<>();
        tracks.forEach(track -> {
            try {
                Document page = Jsoup.connect(searchURLTemplate + track.replace(" ", "%20")).get();
                //log.warn(page.outerHtml());
                Element linkTag = page.select("a.x-icon-download").first();
                links.add(linkTag.attr("href"));
            } catch (IOException e) {
                log.warn(searchURLTemplate + track.replace(" ", "%20") + " is not found.");
            }
        });
        return links;
    }

    public List<String> getLinksToSingers(List<String> singers){
        List<String> links = new LinkedList<>();
        return links;
    }


}
