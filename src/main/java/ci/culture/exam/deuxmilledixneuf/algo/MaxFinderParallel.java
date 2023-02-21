package ci.culture.exam.algo;

import ci.culture.exam.interfaces.MaxFinder;

import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class MaxFinderParallel implements MaxFinder<Double>  {

    @Override
    public Double getMaximum(Collection<Double> input, Function<Double, Double> function) {
        ci.culture.exam.algo.ForkJoinAlgo forkJoinAlgo = new ci.culture.exam.algo.ForkJoinAlgo(input);
        ForkJoinPool.commonPool().invoke(forkJoinAlgo);
//        Logger.getGlobal().log(Level.INFO, "MaxFinderParallel: "+forkJoinAlgo.getMax());
        return forkJoinAlgo.getMax();
    }
}
