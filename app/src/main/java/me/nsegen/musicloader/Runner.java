package me.nsegen.musicloader;

import me.nsegen.musicloader.services.MusicListReader;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by root on 15.9.16.
 */
public class Runner {

    private static final Logger log = Logger.getLogger(Runner.class);

    public static void main(String[] args){

        MusicListReader mlr = MusicListReader.getInstance();
        try {
            mlr.read();
        } catch(IOException e) {
            log.fatal("File " + args[0] + " not found.");
        } catch (SAXException e) {

        }


    }

}
