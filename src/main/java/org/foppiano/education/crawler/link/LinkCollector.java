package org.foppiano.education.crawler.link;

import org.foppiano.education.crawler.Crawler;
import org.foppiano.education.crawler.model.WebLink;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class LinkCollector {
    private Set<WebLink> links;

    public LinkCollector() {
        links = new HashSet<WebLink>();
    }

    public void collect(List<WebLink> incomingLinks) {
        Iterator i = incomingLinks.iterator();
        while(i.hasNext() && links.size() < Crawler.MAX_LINKS) {
            links.add((WebLink) i.next());
        }
    }

    public WebLink getNewLink() {

        Iterator i = links.iterator();
        while(i.hasNext()) {
            WebLink next = ((WebLink) i.next());
            if(next.isVisited() == false) {
                next.setVisited(true);
                return next;
            }
        }

        return null;

    }

    public Set<WebLink> getLinks() {
        return links;
    }
}
