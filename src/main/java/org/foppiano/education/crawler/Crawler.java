package org.foppiano.education.crawler;

import org.foppiano.education.crawler.download.DownloadService;
import org.foppiano.education.crawler.link.LinkParser;
import org.foppiano.education.crawler.download.WebDownloader;
import org.foppiano.education.crawler.link.LinkCollector;
import org.foppiano.education.crawler.model.WebLink;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class Crawler {

    public static Integer MAX_LINKS = 1000;

    DownloadService downloadService;
    LinkCollector collector;

    public Crawler(DownloadService downloadService, LinkCollector collector ) {
        this.downloadService = downloadService;
        this.collector = collector;
    }

    public void crawl(String initialUrl) throws Exception {
        collector.collect(downloadService.process(new WebLink(initialUrl)));

        while(collector.getLinks().size() < MAX_LINKS) {
            collector.collect(downloadService.process(collector.getNewLink()));
        }

        Iterator i = collector.getLinks().iterator();


        while(i.hasNext()) {
            System.out.println((i.next()));
        }
        System.out.println("Extracted "+ collector.getLinks().size() +" links");

    }

    public static void main(String[] args) throws Exception {
        Crawler c = new Crawler(new DownloadService(new WebDownloader(), new LinkParser()), new LinkCollector());

        if(args.length == 1) {
            c.crawl(args[0]);
        } else {
            System.out.println("Usage: java Crawler [starting website] (e.g. java Crawler http://www.google.com)");
        }

    }
}
