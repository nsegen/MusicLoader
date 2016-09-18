package me.nsegen.musicloader.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by root on 15.9.16.
 */
public class MusicListReader {

    private String pathToFile;

    private final String ALL_TRACK_FLAG = "--all";

    private List<String> trackList;
    private List<String> singerList;

    public MusicListReader(String path){
        pathToFile = new String(path);
    }

    public void read() throws FileNotFoundException{
        trackList = new LinkedList<>();
        singerList = new LinkedList<>();
        Scanner sc = new Scanner(new File(pathToFile));
        while(sc.hasNext()){
            String rowInFile = sc.nextLine();
            if(rowInFile.contains(ALL_TRACK_FLAG)){
                singerList.add(rowInFile);
            } else {
                trackList.add(rowInFile);
            }
        }
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<String> getTrackList() {
        return new LinkedList<>(trackList);
    }

    public List<String> getSingerList() {
        return new LinkedList<>(singerList);
    }
}
