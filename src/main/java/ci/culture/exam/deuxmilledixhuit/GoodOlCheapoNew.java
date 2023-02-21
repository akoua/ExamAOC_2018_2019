package ci.culture.exam.deuxmilledixhuit;

import ci.culture.exam.deuxmilledixhuit.entities.Offer;
import ci.culture.exam.deuxmilledixhuit.entities.ProductCategoryImpl;
import ci.culture.exam.deuxmilledixhuit.interfaces.ElCheapo;
import ci.culture.exam.deuxmilledixhuit.interfaces.Vendor;
import ci.culture.exam.deuxmilledixhuit.interfaces.Vendors;

import java.util.Collection;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodOlCheapoNew implements ElCheapo {

    private ExecutorService executorSercie;
    private BlockingQueue<Future<Offer>> vendorsQueue;

    public GoodOlCheapoNew() {
        this.executorSercie = Executors.newFixedThreadPool(10);
        this.vendorsQueue = new ArrayBlockingQueue<>(10);
    }

    @Override
    public Offer getBestOffer(String productName) {
        Collection<Vendor> vendors = Vendors.getVendors().stream().toList();
        AtomicInteger rang = new AtomicInteger();
        Logger.getGlobal().log(Level.INFO, "all Vendors: " + vendors);
        var futures = vendors.stream()
                .parallel()
                .map(vendor -> {
                    Logger.getGlobal().log(Level.INFO, "Vendor " + rang.getAndIncrement() + ": " + vendor);
                    Future<Offer> submit = this.executorSercie.submit(() ->
                            new Offer(vendor.getPrice(productName), vendor, new ProductCategoryImpl(productName)));
                    vendorsQueue.add(submit);
                    return submit;
                })
                .filter(vendorFuture -> vendorFuture.isDone())
                .peek(vendorFuture -> {
                    try {
                        Logger.getGlobal().log(Level.INFO, "Vendor Rang: " + rang.getAndIncrement() + " " + vendorFuture.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).toList();

        Logger.getGlobal().log(Level.INFO, "GoodOlCheapoNew: " + futures.size());
        Vendor lessVendor = null;
        try {
            var bestOffer = this.vendorsQueue.take().get();
            Logger.getGlobal().log(Level.INFO, "Best Offer: " + bestOffer);

            return bestOffer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.executorSercie.shutdown();
        }
    }
}
