package org.foppiano.education.crawler.download;

import org.foppiano.education.crawler.model.WebPage;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:22
 * To change this template use File | Settings | File Templates.
 */
public class WebDownloaderTest {

    WebDownloader target;

    @Before
    public void setUp() throws Exception {
        target = new WebDownloader();
    }

    @Test
    public void testDownloaderSample() throws Exception {

        final String inputUrl = "http://www.google.com";
        WebPage output = target.download(inputUrl);

        assertEquals("The URL doesn't correspond", inputUrl, output.getUrl());
        assertEquals("The URL doesn't correspond", inputUrl, output.toString());
        assertNotNull("The local file should not be null", output.getLocalFile());
    }

    @Test(expected = MalformedURLException.class)
    public void testDownloaderWithBadURL() throws Exception {

        final String inputUrl = "bao.com";
        target.download(inputUrl);

    }


}
