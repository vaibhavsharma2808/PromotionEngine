package org.sku;

import java.util.HashMap;

/*
 * This class provides information about product SKUs and their prices.
 * For further addition of SKUs, add SKU and its price in static block
 */
public class SKU {

    /*
     * This SKU map contains SKUs as keys and respective prices as value
     */
    private static final HashMap<Character, Integer> skuMap = new HashMap<>();

    /*
      static block to initialize sku map
     */
    static {
        skuMap.put('A', 50);
        skuMap.put('B', 30);
        skuMap.put('C', 20);
        skuMap.put('D', 15);
    }

    /*
     * returns character array containing all SKUs
     * @return
     */
    public static Character[] getAllSKUs() {
        return skuMap.keySet().toArray(new Character[skuMap.keySet().size()]);
    }

    /*
     * returns the price of specific SKU provided in parameter
     * @param sku
     * @return
     */
    public static int getSKUPrice(char sku) {
        return skuMap.getOrDefault(sku, 0);
    }
}
