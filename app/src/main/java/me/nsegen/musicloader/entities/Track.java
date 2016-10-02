package me.nsegen.musicloader.entities;

import java.util.Objects;

/**
 * Created by nsegen on 2.10.16.
 */
public class Track {

    private String singerName;
    private String trackName;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public String toString() {
        return "{" +
                "singerName='" + singerName + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return Objects.equals(getSingerName(), track.getSingerName()) &&
                Objects.equals(getTrackName(), track.getTrackName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSingerName(), getTrackName());
    }
}
