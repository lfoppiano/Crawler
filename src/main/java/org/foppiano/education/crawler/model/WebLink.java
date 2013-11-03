package org.foppiano.education.crawler.model;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class WebLink {
    private boolean visited;
    private String url;

    public WebLink(String url, boolean visited) {
        this.visited = visited;
        this.url = url;
    }

    public WebLink(String url) {
        this(url, false);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int hashCode() {
        return url.length();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        WebLink rhs = (WebLink) obj;
        return url.equals(rhs.url);
    }

    public String toString() {
        return this.url;
    }
}
