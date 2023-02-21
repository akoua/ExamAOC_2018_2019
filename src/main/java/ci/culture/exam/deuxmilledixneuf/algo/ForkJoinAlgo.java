package ci.culture.exam.algo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkJoinAlgo extends RecursiveAction {

    private Double max;
    private Collection<Double> input;
    private int SEQUENTIAL_THRESHOLD = 1_000;

//    public ForkJoinAlgo(Collection<Double> input, Splitter<Double> splt, int nbPiece ) {
    public ForkJoinAlgo(Collection<Double> input) {
        this.input = input;
        this.max = 0d;
    }

    @Override
    protected void compute() {
        if ( input.size() <= SEQUENTIAL_THRESHOLD){
//            Logger.getGlobal().log(Level.INFO, "ForkJoinAlgo: "+input);
            max = new ci.culture.exam.algo.MaxFinderSequential().getMaximum(input, (d) -> d);
        }else {
            Collection<Collection<Double>> split = new ci.culture.exam.algo.SplitterTwiceImpl().split(input, SEQUENTIAL_THRESHOLD);
            var left = new ForkJoinAlgo(split.stream().toList().get(0));
            var right = new ForkJoinAlgo(split.stream().toList(). get(1));
            left.fork();
            right.compute();
            left.join();
            this.max = new ci.culture.exam.algo.MaxFinderSequential().getMaximum(List.of(left.max, right.max), (d) -> d);
        }

    }

    public Double getMax() {
        return max;
    }
}
