package org.foppiano.education.crawler.model;

import java.io.File;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:31
 * To change this template use File | Settings | File Templates.
 */
public class WebPage {

    private String url;
    private URL location;
    private File localFile;

    public WebPage(URL location, File localFile) {
        this.location = location;
        this.localFile = localFile;
        if (location != null) {
            this.url = location.toString();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }

    public File getLocalFile() {
        return localFile;
    }

    public void setLocalFile(File localFile) {
        this.localFile = localFile;
    }

    public String toString() {
        return this.getUrl();
    }
}
