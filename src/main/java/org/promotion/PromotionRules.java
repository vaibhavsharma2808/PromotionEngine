package org.promotion;

import java.util.HashMap;

/*
 * This class provides information about all the configured promotions.
 * For further addition of promotion rules, add promo code and its price in static block
 */
public class PromotionRules {

    /*
     * This promo rules map contains promo codes as keys and respective promo prices as value
     */
    private static final HashMap<String, Integer> promoRulesMap = new HashMap<>();

    /*
     * static block to initialize promo rules map (promo_code, price)
     */
    static {
        promoRulesMap.put("AAA", 130);
        promoRulesMap.put("BB", 45);
        promoRulesMap.put("CD", 30);
        // Further rules can be added in same way,
        // if we have some formula to get the promo price then create the function by implementing formula and return promo price
        // promoRulesMap.put("AB", functionFormulaPrice());
    }

    /*
     * returns string array containing all promo codes
     * @return
     */
    public static String[] getAllPromoRules() {
        return promoRulesMap.keySet().toArray(new String[promoRulesMap.keySet().size()]);
    }

    /*
     * returns the price of specific promo code provided in parameter
     * @param rule
     * @return
     */
    public static int getPromoRulePrice(String rule) {
        return promoRulesMap.getOrDefault(rule, 0);
    }
}
