package me.nsegen.musicloader;

import me.nsegen.musicloader.services.MusicListReader;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

/**
 * Created by root on 15.9.16.
 */
public class Runner {

    private static final Logger log = Logger.getLogger(Runner.class);

    public static void main(String[] args){

        MusicListReader mlr = new MusicListReader(args[0]);
        try {
            mlr.read();
        } catch(FileNotFoundException e) {
            log.fatal("File " + args[0] + " not found.");
        }


    }

}
