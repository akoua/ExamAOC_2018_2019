package ci.culture.exam.deuxmilledixhuit;

import ci.culture.exam.deuxmilledixhuit.entities.ProductCategoryImpl;
import ci.culture.exam.deuxmilledixhuit.entities.Offer;
import ci.culture.exam.deuxmilledixhuit.entities.VendorImpl;
import ci.culture.exam.deuxmilledixhuit.interfaces.ElCheapo;
import ci.culture.exam.deuxmilledixhuit.interfaces.Vendor;
import ci.culture.exam.deuxmilledixhuit.interfaces.Vendors;

import java.util.Collection;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodOlCheapo implements ElCheapo {
    @Override
    public Offer getBestOffer(String productName) {
        Collection<Vendor> vendors = Vendors.getVendors().stream().toList();
        Logger.getGlobal().log(Level.INFO, "all Vendors: "+vendors);
        Vendor lessVendor = vendors.stream()
                .min(Comparator.comparingDouble(vendor -> vendor.getPrice(productName)))
                .orElse(new VendorImpl());

        return new Offer(lessVendor.getPrice( productName), lessVendor, new ProductCategoryImpl("suggar"));
    }
}
