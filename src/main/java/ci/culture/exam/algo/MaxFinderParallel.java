package ci.culture.exam.algo;

import ci.culture.exam.interfaces.MaxFinder;

import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxFinderParallel implements MaxFinder<Double>  {

    @Override
    public Double getMaximum(Collection<Double> input, Function<Double, Double> function) {
        ForkJoinAlgo forkJoinAlgo = new ForkJoinAlgo(input);
        ForkJoinPool.commonPool().invoke(forkJoinAlgo);
//        Logger.getGlobal().log(Level.INFO, "MaxFinderParallel: "+forkJoinAlgo.getMax());
        return forkJoinAlgo.getMax();
    }
}
