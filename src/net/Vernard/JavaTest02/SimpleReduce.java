package net.Vernard.JavaTest02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class SimpleReduce {

    public static void main(String... args) {
        //suppose you have a list of integers stored in an array, randomly picked and sorted
        List<Integer> list = Arrays.asList(-3,21,443,80,72,5,16,-46);
        List<Integer> negatives = Arrays.asList(-11,-1,-34,-1232,-66,-12,-92);
        // let's combine them into one array...
        List<List<Integer>> printOut = Arrays.asList(list, negatives);

        //a simple reduction can be used to find the max value in the array
        Integer reduceMax =
                (list.stream()
                        .reduce(0, Integer::max));
        Integer reduceMin =
                (list.stream()
                        .reduce(0, Integer::min));

        //but because the identity above is "0", if you try to look for the "max" on values that are all negative it will always return "0"
        Integer wrongMax =
                (negatives.stream()
                        .reduce(0, Integer::max));

        //for it to not return 0, you have to get rid of the "identity" (.reduce(0,Integer::min) --> .reduce(integer::min)) then use optional like this:
        Optional<Integer> maxOfNegatives =
                (negatives.stream()
                        .reduce(Integer::max)); //this will properly

        System.out.println();
        System.out.println(printOut + "\n"
                            + "Max: " + reduceMax + "\n"
                            + "Min: " + reduceMin + "\n"
                            + "Wrong Max (Negatives): " + wrongMax + "\n"
                            + "Right Max (Negatives): " + maxOfNegatives);

    }

}