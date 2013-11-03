package org.foppiano.education.crawler.link;

import org.foppiano.education.crawler.model.WebLink;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 03/11/13
 * Time: 07:30
 * To change this template use File | Settings | File Templates.
 */
public class LinkCollectorTest {

    LinkCollector target;

    @Before
    public void setUp() throws Exception {

        target = new LinkCollector();

    }

    @Test
    public void testCollect() throws Exception {

        List<WebLink> someData = new ArrayList<WebLink>();

        someData.add(new WebLink("http://www.google.com"));
        someData.add(new WebLink("http://www.google.it"));
        someData.add(new WebLink("http://www.google.com"));
        someData.add(new WebLink("http://www.google.fr"));
        someData.add(new WebLink("http://www.google.lu"));
        someData.add(new WebLink("http://www.google.com"));

        target.collect(someData);

        assertEquals("Links are not in the right number", 4, target.getLinks().size());

    }

    @Test
    public void testGetNewLink() throws Exception {
        List<WebLink> someData = new ArrayList<WebLink>();

        someData.add(new WebLink("http://www.google.com", false));
        someData.add(new WebLink("http://www.google.it", true));

        target.collect(someData);

        WebLink link = target.getNewLink();
        assertEquals("Link is not correct", "http://www.google.com", link.getUrl());
        link = target.getNewLink();
        assertNull("Link is not correct", link);

    }

    @Test
    public void testGetNewLinkAllVisited() throws Exception {
        List<WebLink> someData = new ArrayList<WebLink>();

        someData.add(new WebLink("http://www.google.com", true));
        someData.add(new WebLink("http://www.google.it", true));

        target.collect(someData);

        WebLink link = target.getNewLink();
        assertNull("Link is not correct", link);
        link = target.getNewLink();
        assertNull("Link is not correct", link);

    }


    @Test
    public void testStopIfLimitReached() throws Exception {
        //TODO
    }
}
