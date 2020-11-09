package lessonPack;

import lessonPack.domain.Product;

public class InitData {

    private static Product PRODUCT_ONE = new Product();
    private static Product PRODUCT_TWO = new Product();
    private static Product PRODUCT_THREE = new Product();
    private static Product PRODUCT_FOUR = new Product();
    private static Product PRODUCT_FIVE = new Product();

    {
        PRODUCT_ONE.setTitle("milk");
        PRODUCT_ONE.setCost(50.0);
        System.out.println("milk");

        PRODUCT_TWO.setTitle("bread");
        PRODUCT_TWO.setCost(25.0);

        PRODUCT_THREE.setTitle("water");
        PRODUCT_THREE.setCost(15.0);

        PRODUCT_FOUR.setTitle("oil");
        PRODUCT_FOUR.setCost(75.0);

        PRODUCT_FIVE.setTitle("cheese");
        PRODUCT_FIVE.setCost(43.0);
    }

    public static Product getProductOne() {
        return PRODUCT_ONE;
    }

    public static void setProductOne(Product productOne) {
        PRODUCT_ONE = productOne;
    }

    public static Product getProductTwo() {
        return PRODUCT_TWO;
    }

    public static void setProductTwo(Product productTwo) {
        PRODUCT_TWO = productTwo;
    }

    public static Product getProductThree() {
        return PRODUCT_THREE;
    }

    public static void setProductThree(Product productThree) {
        PRODUCT_THREE = productThree;
    }

    public static Product getProductFour() {
        return PRODUCT_FOUR;
    }

    public static void setProductFour(Product productFour) {
        PRODUCT_FOUR = productFour;
    }

    public static Product getProductFive() {
        return PRODUCT_FIVE;
    }

    public static void setProductFive(Product productFive) {
        PRODUCT_FIVE = productFive;
    }
}
