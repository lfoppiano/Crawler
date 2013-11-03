package org.foppiano.education.crawler.link;

import org.foppiano.education.crawler.link.LinkParser;
import org.foppiano.education.crawler.model.WebLink;
import org.foppiano.education.crawler.model.WebPage;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class LinkParserTest {

    LinkParser target;

    @Before
    public void setUp() {
        target = new LinkParser();
    }

    @Test
    public void testParsePage() throws Exception {
        File locationExample = new File(this.getClass().getResource("example2.downloaded_page.html").toURI());

        List<WebLink> links = target.parsePage(new WebPage(new URL("http://www.google.com"), locationExample));

        assertTrue("No Links found", links.size() > 0 );
        assertEquals("The Found links are not correct", 3, links.size());
    }
}
