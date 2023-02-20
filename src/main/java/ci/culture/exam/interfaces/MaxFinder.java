package ci.culture.exam.interfaces;

import java.util.Collection;
import java.util.function.Function;

public interface MaxFinder<T> {
    /**
     * Returns the element of the input collection that has the highest
     value for a function given as a parameter
     * @param input is a collection elements
     * @param function a function applied to each element of the input
    collection
     * @return the element that gets the highest value for function
     */
    T getMaximum(Collection<T> input, Function<T,Double> function);
}
