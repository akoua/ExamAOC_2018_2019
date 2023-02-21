package ci.culture.exam.deuxmilledixhuit.entities;

import ci.culture.exam.deuxmilledixhuit.interfaces.ProductCategory;
import ci.culture.exam.deuxmilledixhuit.interfaces.Vendor;

public class Offer {
    private double price;
    private Vendor vendor;
    private ProductCategory category;

    public Offer(double price, Vendor vendor, ProductCategory category) {
        this.price = price; this.vendor = vendor; this.category = category;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "price=" + price +
                ", vendor=" + vendor +
                ", category=" + category +
                '}';
    }
}
