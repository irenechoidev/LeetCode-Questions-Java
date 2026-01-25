class Cashier {

    Map<Integer, Integer> priceMap;
    int numberForDiscount;
    int customerNumber;
    int discount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        customerNumber = 0;
        numberForDiscount = n;
        this.discount = discount;
        priceMap = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            priceMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += priceMap.get(product[i]) * amount[i];
        }
        return applyDiscount(total);
    }

    private double applyDiscount(double bill) {
        customerNumber++;
        if (customerNumber % numberForDiscount == 0) {
            return bill * (double) ((100.0 - discount) / 100);
        }
        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */