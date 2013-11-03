package org.foppiano.education.crawler.download;

import org.foppiano.education.crawler.model.WebLink;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class DownloadService implements Runnable{

    private WebDownloader downloader;
    private LinkParser parser;

    public DownloadService(WebDownloader downloader, LinkParser parser) {
        this.downloader = downloader;
        this.parser = parser;
    }

    public List<WebLink> process(WebLink link) {
        List<WebLink> links = new ArrayList<WebLink>();
        try {
            links = parser.parsePage(downloader.download(link.getUrl()));
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return links;
    }

    @Override
    public void run() {
        //nothing for now
    }
}
