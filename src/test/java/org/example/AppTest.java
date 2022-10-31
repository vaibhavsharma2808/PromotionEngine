package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.promotion.PromotionApplicator;

/*
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /*
     * Create the test case
     *
     * @param testName name of the test case
     */
    PromotionApplicator promoApplicator = null;
    public AppTest( String testName )
    {
        super( testName );
        promoApplicator = new PromotionApplicator();
    }

    /*
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void testCase1() {
        char[] cartItems = new char[]{'A','B','C'};
        int cartPrice = promoApplicator.applyPromotions(cartItems);
        assertTrue( cartPrice == 100 );
    }

    public void testCase2() {
        char[] cartItems = new char[]{'A','A','A','A','A','B','B','B','B','B','C'};
        int cartPrice = promoApplicator.applyPromotions(cartItems);
        assertTrue( cartPrice == 370 );
    }

    public void testCase3() {
        char[] cartItems = new char[]{'A','A','A','B','B','B','B','B','C','D'};
        int cartPrice = promoApplicator.applyPromotions(cartItems);
        assertTrue(cartPrice == 280);
    }
}
