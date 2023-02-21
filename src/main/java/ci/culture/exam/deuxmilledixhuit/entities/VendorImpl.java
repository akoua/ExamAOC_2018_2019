package ci.culture.exam.deuxmilledixhuit.entities;

import ci.culture.exam.deuxmilledixhuit.interfaces.Vendor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VendorImpl implements Vendor {

    private Map<String, Double> productNamePrice;

    public VendorImpl() {
        this.productNamePrice = new HashMap<>();
        this.productNamePrice.put("ProductName", new Random().nextDouble(0, 1_000));
    }

    @Override
    public double getPrice(String productName) {
        return this.productNamePrice.get(productName);
    }

    @Override
    public String toString() {
        return "VendorImpl{" +
                "productPrice=" + productNamePrice +
                '}';
    }
}
