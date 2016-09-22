package me.nsegen.musicloader.services;

import org.apache.log4j.Logger;

/**
 * Created by root on 15.9.16.
 */
public class Loader {

    private static final Logger log = Logger.getLogger(Loader.class);

    public String resultDirectory;

    private static Loader loader;

    private Loader(){
    }

    public static Loader getInstance() {

        if(loader == null){
            loader = new Loader();
        }
        return loader;
    }
}
