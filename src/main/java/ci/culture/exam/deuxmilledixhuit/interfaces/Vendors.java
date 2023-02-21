package ci.culture.exam.deuxmilledixhuit.interfaces;

import ci.culture.exam.deuxmilledixhuit.entities.VendorImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Vendors {
    /**
     * Obtenir la collection en lecture seule de tous les vendeurs
     * employés dans la recherche de la meilleure offre
     *
     * @return la collection des vendeurs
     */
     static Collection<Vendor> getVendors() {
         return Stream.generate(VendorImpl::new).limit(5).collect(Collectors.toList());
    }
}
