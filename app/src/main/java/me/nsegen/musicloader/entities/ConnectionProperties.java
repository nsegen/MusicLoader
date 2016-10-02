package me.nsegen.musicloader.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nsegen on 1.10.16.
 */
public class ConnectionProperties {

    protected String host;
    protected String searchTemplate;
    protected Map<String, String> cookies;
    protected String tagName;
    protected String downloadLinkClass;
    protected Map<String, String> attributes;
    protected String linkAttribute;

    public ConnectionProperties(){
        cookies = new HashMap<>();
        attributes = new HashMap<>();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSearchTemplate() {
        return searchTemplate;
    }

    public void setSearchTemplate(String searchTemplate) {
        this.searchTemplate = searchTemplate;
    }

    public Map<String, String> getCookies() {
        return new HashMap<>(cookies);
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDownloadLinkClass() {
        return downloadLinkClass;
    }

    public void setDownloadLinkClass(String downloadLinkClass) {
        this.downloadLinkClass = downloadLinkClass;
    }

    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getLinkAttribute() {
        return linkAttribute;
    }

    public void setLinkAttribute(String linkAttribute) {
        this.linkAttribute = linkAttribute;
    }

    public void addCookie(String key, String value){
        cookies.put(key, value);
    }

    public void addAttribute(String key, String value){
        attributes.put(key, value);
    }

    @Override
    public String toString() {
        return "ConnectionProperties{" +
                "host='" + host + '\'' +
                ", searchTemplate='" + searchTemplate + '\'' +
                ", cookies=" + cookies +
                ", tagName='" + tagName + '\'' +
                ", downloadLinkClass='" + downloadLinkClass + '\'' +
                ", attributes=" + attributes +
                ", linkAttribute='" + linkAttribute + '\'' +
                '}';
    }
}
