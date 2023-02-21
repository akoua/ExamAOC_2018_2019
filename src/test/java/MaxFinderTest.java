import ci.culture.exam.algo.MaxFinderParallel;
import ci.culture.exam.algo.MaxFinderSequential;
import ci.culture.exam.interfaces.MaxFinder;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxFinderTest {

    @Test
    public void testSequentiel() {
        MaxFinder<Double> maxFinder = new MaxFinderSequential();
        Collection<Double> input = List.of(-1.0, 2.0, 3.0);
        assertEquals(3.0, (maxFinder.getMaximum(input, (d) ->d
//        {
//            int i = new Random().nextInt(15);
//            Logger.getGlobal().log(Level.INFO, d+": Gen -> "+i);
//            return d + i;
//        }
        )).doubleValue(), 1e-12);
    }

    @Test
    public void testParallel() {
        MaxFinder<Double> maxFinder = new MaxFinderParallel();
        List<Double> input = DoubleStream.generate(()
                -> Math.random() * 10).limit(100_000).boxed().collect(Collectors.toList());
//        Logger.getGlobal().log(Level.INFO, "testParallel: "+input.size());
        Logger.getGlobal().log(Level.INFO, "testParallel: "+input);
        assertEquals(3.0, (maxFinder.getMaximum(input, (d) ->d
//        {
//            int i = new Random().nextInt(15);
//            Logger.getGlobal().log(Level.INFO, d+": Gen -> "+i);
//            return d + i;
//        }
        )).doubleValue(), 1e-12);
    }
}
