package me.nsegen.musicloader.utils;

import me.nsegen.musicloader.entities.ConnectionProperties;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nsegen on 1.10.16.
 */
public class SAXParserSitesPropertiesHandler extends DefaultHandler {

    private static final Logger log = Logger.getLogger(SAXParserSitesPropertiesHandler.class);

    List<ConnectionProperties> connProps;
    ConnectionProperties currentSite;

    public SAXParserSitesPropertiesHandler(){
        connProps = new LinkedList<>();
    }

    public List<ConnectionProperties> getConnectionProperties(){
        return new LinkedList<>(connProps);
    }

    @Override
    public void startDocument() throws SAXException {
        connProps = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "site":
                currentSite = new ConnectionProperties();
                currentSite.setHost(attributes.getValue("host"));
                currentSite.setSearchTemplate(attributes.getValue("search-template"));
                break;
            case "cookie":
                currentSite.addCookie(attributes.getValue("key"), attributes.getValue("value"));
                break;
            case "html-element":
                currentSite.setTagName(attributes.getValue(uri, "tag"));
                currentSite.setDownloadLinkClass(attributes.getValue("class"));
                currentSite.setLinkAttribute(attributes.getValue("link-attr"));
                break;
            case "attr":
                currentSite.addAttribute(attributes.getValue("name"), attributes.getValue("value"));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("site")){
            connProps.add(currentSite);
        }
    }
}
