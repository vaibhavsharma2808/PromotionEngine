package org.promotion;

import org.sku.SKU;

import java.util.Arrays;

public class PromotionApplicator {

    char[] cartItems = null;

    public int applyPromotions(char[] cartItems) {
        Arrays.sort(cartItems);
        this.cartItems = cartItems;
        String applicablePromos = getAllApplicablePromos();
        System.out.println("SKUs in cart on which promo not applied >>" + convertToString(this.cartItems));
        return getCartValue(this.cartItems, applicablePromos);
    }

    /*
     * Determines what all promo codes can be applied
     * @param cartItems
     * @return
     */
    private String getAllApplicablePromos() {
        String applicablePromos = "";
        String cartSKUs = convertToString(cartItems);
        String cartSKUsCopy = new String(cartSKUs);
        for (String promoCode: PromotionRules.getAllPromoRules()) {
            while (cartSKUsCopy.contains(promoCode)) {
                cartSKUsCopy = cartSKUsCopy.substring(0, cartSKUsCopy.indexOf(promoCode))
                        +
                        cartSKUsCopy.substring(cartSKUsCopy.indexOf(promoCode)+promoCode.length());
                applicablePromos += promoCode+",";
            }
        }
        this.cartItems = cartSKUsCopy.toCharArray();
        System.out.println("Applicable promo codes are >> "+applicablePromos);
        return applicablePromos.length() > 0 ? applicablePromos.substring(0, applicablePromos.length()-1) : applicablePromos;
    }

    /*
     * Get total cart value including both promotional SKUs and non-promotional SKUs
     * @param cartItems
     * @param applicablePromos
     * @return
     */
    private int getCartValue(char[] cartItems, String applicablePromos) {
        int cartValue = 0;
        /* get total price for skus with no promo applicable */
        for (char itemSKU: cartItems) {
            cartValue += SKU.getSKUPrice(itemSKU);
        }
        /* get total price for skus with no promo applicable */
        cartValue += getApplicablePromosTotalPrice(applicablePromos);
        return cartValue;
    }


    /*
     * get total price for skus with no promo applicable
     * @param applicablePromos
     * @return
     */
    private int getApplicablePromosTotalPrice(String applicablePromos) {
        int totalPrice = 0;
        for (String promo : applicablePromos.split(",")) {
            totalPrice += PromotionRules.getPromoRulePrice(promo);
        }
        return totalPrice;
    }

    private String convertToString(char[] skus) {
        String skusStr = "";
        for (char sku: skus) {
            skusStr += Character.toString(sku);
        }
        return skusStr;
    }
}
