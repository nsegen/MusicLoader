package me.nsegen.musicloader.utils;

import me.nsegen.musicloader.entities.ConnectionProperties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

/**
 * Created by nsegen on 2.10.16.
 */
public class SAXParserSitesPropertiesHandlerTest {

    private SAXParserFactory factory;
    private SAXParser parser;
    private SAXParserSitesPropertiesHandler SAXParserSitesPropertiesHandler;
    private File file;

    @Before
    public void setUp() throws Exception {
        factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        SAXParserSitesPropertiesHandler = new SAXParserSitesPropertiesHandler();
        file = new File(Thread.currentThread().getContextClassLoader().getResource("MusicHostsProperties.xml").getPath());
        parser.parse(file, SAXParserSitesPropertiesHandler);

    }

    @Test
    public void getConnectionProperties() throws Exception {
        List<ConnectionProperties> list = SAXParserSitesPropertiesHandler.getConnectionProperties();
        Assert.assertEquals(list.size(), 2);
        Assert.assertEquals(list.get(0).getHost(), "http://www.zv.fm");
        Assert.assertEquals(list.get(0).getSearchTemplate(), "/mp3/search?keywords=");
        Assert.assertEquals(list.get(1).getHost(), "http://www.mixpromo.net");
        Assert.assertEquals(list.get(1).getSearchTemplate(), "/search/");
    }

}