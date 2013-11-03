package org.foppiano.education.crawler.download;

import org.foppiano.education.crawler.model.WebPage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 02/11/13
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
public class WebDownloader {

    public WebPage download(String inputUrl) throws MalformedURLException {
        OutputStream output = null;
        File tmpFile = null;

        URL url = new URL(inputUrl);
        try {

            InputStream is = downloadContentAsInputStream(url);

            tmpFile = File.createTempFile("tmp_", "_downloaded", new File("/tmp"));

            output = new FileOutputStream(tmpFile);

            byte[] buffer = new byte[4096];
            int n = -1;
            while ((n = is.read(buffer)) != -1) {
                if (n > 0) {
                    output.write(buffer, 0, n);
                }
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return new WebPage(url, tmpFile);

    }

    private InputStream downloadContentAsInputStream(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        conn.setAllowUserInteraction(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.connect();
        return conn.getInputStream();
    }
}