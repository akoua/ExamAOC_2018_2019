package ci.culture.exam.algo;

import ci.culture.exam.interfaces.MaxFinder;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public class MaxFinderSequential implements MaxFinder<Double> {
    @Override
    public Double getMaximum(Collection<Double> input, Function<Double, Double> function) {
        Optional<Double> val = Optional.empty();
        for (Double aDouble : input) {
            aDouble = function.apply(aDouble);
            if (val.isEmpty())
                val = Optional.of(aDouble);
            else if (val.get() < aDouble )
                val = Optional.of(aDouble);
        }
//        Logger.getGlobal().log(Level.INFO, "MaxFinderSequential: "+val.get());
        return val.get();
    }
}
