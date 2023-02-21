package ci.culture.exam;

import ci.culture.exam.deuxmilledixhuit.GoodOlCheapoNew;
import ci.culture.exam.deuxmilledixhuit.entities.Offer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Offer bestOffer = new GoodOlCheapoNew().getBestOffer("ProductName");
        Logger.getGlobal().log(Level.INFO, "Best offer: "+bestOffer);
    }
}