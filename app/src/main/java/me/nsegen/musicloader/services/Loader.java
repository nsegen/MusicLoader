package me.nsegen.musicloader.services;

import me.nsegen.musicloader.entities.Track;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by root on 15.9.16.
 */
public class Loader {

    private static final Logger log = Logger.getLogger(Loader.class);

    private String resultDirectory;

    private static Loader loader;

    private Loader(){
        resultDirectory = "~/Music";
    }

    public static Loader getInstance() {

        if(loader == null){
            loader = new Loader();
        }
        return loader;
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }

    public void downloadTracks(Map<Track, List<String>> tracks){
        tracks.forEach((track, links) -> {
            links = links.stream().filter(link -> link != null).collect(Collectors.toList());
            downloadTrack(track, links.iterator());
        });
    }

    private void downloadTrack(Track track, Iterator<String> iterator) {

        try {
            URL url = new URL(iterator.next());
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(resultDirectory);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            if(iterator.hasNext()){
                downloadTrack(track, iterator);
            } else {
                log.warn("track " + track.getSingerName() + " - " + track.getTrackName() + "doesn't download:" + e);
            }

        }

    }
}
