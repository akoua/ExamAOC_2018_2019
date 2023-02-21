import ci.culture.exam.deuxmilledixhuit.GoodOlCheapo;
import ci.culture.exam.deuxmilledixhuit.GoodOlCheapoNew;
import ci.culture.exam.deuxmilledixhuit.entities.Offer;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElCheapoTest {

    @Test
    public void testOldGoodOlCheapo() {
        Offer bestOffer = new GoodOlCheapo().getBestOffer("ProductName");
        Logger.getGlobal().log(Level.INFO, "Best offer: "+bestOffer);
    }

    @Test
    public void testNewGoodOlCheapo() {
        Offer bestOffer = new GoodOlCheapoNew().getBestOffer("ProductName");
        Logger.getGlobal().log(Level.INFO, "Best offer: "+bestOffer);
    }
}
