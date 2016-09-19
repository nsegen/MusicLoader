package me.nsegen.musicloader;

import me.nsegen.musicloader.services.MusicListReader;

import java.io.FileNotFoundException;

/**
 * Created by root on 15.9.16.
 */
public class Runner {

    public static void main(String[] args){

        MusicListReader mlr = new MusicListReader(args[0]);
        try {
            mlr.read();
        } catch(FileNotFoundException e) {
            System.err.println("File " + args[0] + " not found.");
        }


    }

}
