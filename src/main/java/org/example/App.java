package org.example;

import org.promotion.PromotionApplicator;

public class App
{
    public static void main( String[] args )
    {
        char[] cartItems = new char[]{'A','A','A','B','B','B','B','B','C','D'};
        PromotionApplicator promoApplicator = new PromotionApplicator();
        System.out.println("Final Cart Value >> "+ promoApplicator.applyPromotions(cartItems));
    }
}

