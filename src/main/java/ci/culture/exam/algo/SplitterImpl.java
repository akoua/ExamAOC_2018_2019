package ci.culture.exam.algo;

import ci.culture.exam.interfaces.Splitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SplitterImpl implements Splitter<Double> {
    @Override
    public Collection<Collection<Double>> split(Collection<Double> input, int numberOfPieces) {
        Collection<Collection<Double>> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger();

        if (numberOfPieces >= input.size()){
             result = List.of(input);
        }
        input.stream().parallel().collect(groupingBy(x->counter.getAndIncrement()/numberOfPieces))
                .values()
                .forEach(result::add);

        Logger.getGlobal().log(Level.INFO, "Split: "+result);

        return result;
    }
}
