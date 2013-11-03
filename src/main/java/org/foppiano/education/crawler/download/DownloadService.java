package org.foppiano.education.crawler.download;

import org.foppiano.education.crawler.exception.RemoteException;
import org.foppiano.education.crawler.link.LinkParser;
import org.foppiano.education.crawler.model.WebLink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class DownloadService {

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
            System.out.println("Visited "+ link.getUrl()+", extracted " + links.size()+" links.");
        } catch (RemoteException e) {
            System.err.println("Some problem with the external web site "+link.getUrl() +". Skipping. ");
        } catch (IOException e) {
            System.err.println("Some problem to extract links from " + link.getUrl() + ". Skipping.");
        }

        return links;
    }
}
