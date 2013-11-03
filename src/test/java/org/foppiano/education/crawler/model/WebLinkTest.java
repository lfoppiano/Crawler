package org.foppiano.education.crawler.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: lfoppiano
 * Date: 03/11/13
 * Time: 07:46
 * To change this template use File | Settings | File Templates.
 */
public class WebLinkTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testHashCodeDifferent() throws Exception {
        int hc1 = new WebLink("http://www.google.com").hashCode();
        int hc2 = new WebLink("http://www.google.it").hashCode();

        assertFalse("Hash codes are corresponding, they shouldn't", hc1 == hc2);
    }

    @Test
    public void testHashCodeEquals() throws Exception {
        int hc1 = new WebLink("http://www.google.it").hashCode();
        int hc2 = new WebLink("http://www.google.it").hashCode();

        assertEquals("Hash codes are not corresponding, they shouldn't", hc1, hc2);
    }

    @Test
    public void testEquals() throws Exception {
        WebLink l1 = new WebLink("http://www.google.it");
        WebLink l2 = new WebLink("http://www.google.it");

        boolean equals1 = l1.equals(l2);
        assertTrue("Element are not correctly recognized ad equals", equals1);
        boolean equals2 = l2.equals(l1);
        assertTrue("Element are not correctly recognized ad equals", equals2);
    }

    @Test
    public void testDisEquals() throws Exception {
        WebLink l1 = new WebLink("http://www.google.it");
        WebLink l2 = new WebLink("http://www.google.com");

        boolean equals1 = l1.equals(l2);
        assertFalse("Element are not correctly recognized ad disequals", equals1);
        boolean equals2 = l2.equals(l1);
        assertFalse("Element are not correctly recognized ad disequals", equals2);
    }
}
