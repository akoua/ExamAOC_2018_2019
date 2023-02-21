package ci.culture.exam.algo;

import ci.culture.exam.interfaces.Splitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;

/**
 * Split list in two elements
 */
public class SplitterTwiceImpl implements Splitter<Double> {
    @Override
    public Collection<Collection<Double>> split(Collection<Double> input, int numberOfPieces) {
        Collection<Collection<Double>> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger();

        input.stream().parallel().collect(groupingBy(x -> {
            if(counter.getAndIncrement() < numberOfPieces) {
                return 0;
            }else {
                return 1;
            }
        })).values()
                .forEach(result::add);

//        Logger.getGlobal().log(Level.INFO, "Split: "+collect);

        return result;
    }
}
