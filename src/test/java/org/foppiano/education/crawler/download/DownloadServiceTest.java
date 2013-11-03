package org.foppiano.education.crawler.download;

import org.foppiano.education.crawler.link.LinkParser;
import org.foppiano.education.crawler.model.WebLink;
import org.foppiano.education.crawler.model.WebPage;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class DownloadServiceTest {
    DownloadService target;
    private WebDownloader mockDownloader;
    private LinkParser mockParser;

    @Before
    public void setUp() throws Exception {
        mockDownloader = createMock(WebDownloader.class);
        mockParser = createMock(LinkParser.class);

        target = new DownloadService(mockDownloader, mockParser);
    }

    @Test
    public void testProcess() throws Exception {

        WebPage fakeWebPage = new WebPage(null, null);
        List<WebLink> fakeLinksList = new ArrayList<WebLink>();
        fakeLinksList.add(new WebLink("http://baobao.it"));
        fakeLinksList.add(new WebLink("http://baobao1.com"));
        fakeLinksList.add(new WebLink("http://baobao2.it"));

        expect(mockDownloader.download("http://www.validurl.com")).andReturn(fakeWebPage);
        expect(mockParser.parsePage(fakeWebPage)).andReturn(fakeLinksList);

        replay(mockDownloader, mockParser);

        List<WebLink> result = target.process(new WebLink("http://www.validurl.com"));

        verify(mockDownloader, mockParser);

        assertTrue(result.size() == fakeLinksList.size());

    }
}
