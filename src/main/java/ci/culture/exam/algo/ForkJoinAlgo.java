package ci.culture.exam.algo;

import ci.culture.exam.interfaces.Splitter;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForkJoinAlgo extends RecursiveAction {

    private Double max;
    private Collection<Double> input;
    private Splitter<Double> splitter;
    private int numberOfPieces;
    private int SEQUENTIAL_THRESHOLD = 3;

//    public ForkJoinAlgo(Collection<Double> input, Splitter<Double> splt, int nbPiece ) {
    public ForkJoinAlgo(Collection<Double> input) {
        this.input = input;
        this.max = 0d;
//        this.splitter = splt;
//        this.numberOfPieces = nbPiece;
    }

    @Override
    protected void compute() {
        if ( input.size() <= SEQUENTIAL_THRESHOLD){
//            Logger.getGlobal().log(Level.INFO, "ForkJoinAlgo: "+input);
            max = new MaxFinderSequential().getMaximum(input, (d) -> d);
        }else {
            Collection<Collection<Double>> split = new SplitterTwiceImpl().split(input, SEQUENTIAL_THRESHOLD);
            var left = new ForkJoinAlgo(split.stream().toList().get(0));
            var right = new ForkJoinAlgo(split.stream().toList(). get(1));
            left.fork();
            right.compute();
            left.join();
            this.max = new MaxFinderSequential().getMaximum(List.of(left.max, right.max), (d) -> d);
        }

    }

    public Double getMax() {
        return max;
    }
}
