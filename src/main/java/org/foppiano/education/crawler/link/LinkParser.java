package org.foppiano.education.crawler.link;

import org.foppiano.education.crawler.model.WebLink;
import org.foppiano.education.crawler.model.WebPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:17
 * To change this template use File | Settings | File Templates.
 */
public class LinkParser {
    public List<WebLink> parsePage(WebPage page) {

        List<WebLink> links = new ArrayList<WebLink>();
        InputStream fis = null;

        //Pattern patternAbsoluteLink = Pattern.compile("\\s*(?i)href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))");
        Pattern patternAbsoluteLink = Pattern.compile("(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?");

        try {
            fis = new FileInputStream(page.getLocalFile());

            byte[] b = new byte[fis.available()];
            fis.read(b);
            String text = new String(b);

            text = text.replaceAll("\\n", " ");

            Matcher matcher = patternAbsoluteLink.matcher(text);

            while (matcher.find()) {
                String found = matcher.group().replaceAll("\"", "");
                links.add(new WebLink(found));
            }

        } catch (IOException e) {
            System.err.println("Something wrong while extracting links. Skipping.");
        } finally {
            //Cleaning up
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Something wrong happened. Skipping.");
                }
            }
            page.getLocalFile().deleteOnExit();


        }

        return links;
    }
}
