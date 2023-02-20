package ci.culture.exam.interfaces;

import java.util.Collection;

public interface Splitter<T> {
    /**
     * Splits a collection into a collection of
     * 'numberOfPieces' collections of approximately
     * equal sizes.
     */
     Collection<Collection<T>> split(Collection<T> c, int
            numberOfPieces);

}
