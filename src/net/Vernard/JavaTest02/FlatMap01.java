package net.Vernard.JavaTest02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMap01 {

    public static void main(String... args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7); // array list of integers, consecutive
        List<Integer> list2 = Arrays.asList(2, 4, 6); // array list of even integers
        List<Integer> list3 = Arrays.asList(3, 5, 7); // array list of odd integers

        // let's combine them into one array...
        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        // let's print them all in array format (list1,list2,list3)...
        System.out.println(list);

        // let's print their entity size (how many integers are in the array)
        Function<List<?>, Integer> size = List::size;

        Function<List<Integer>, Stream<Integer>> flatmapper =
                l -> l.stream();

        list.stream()
                .flatMap(flatmapper) // this will return the CONTENTS of all 3 array lists per line
                // .map(flatmapper) // this returns the following below:
                    //--> java.util.stream.ReferencePipeline$Head@34a245ab
                    //--> java.util.stream.ReferencePipeline$Head@7cc355be
                    //--> java.util.stream.ReferencePipeline$Head@6e8cf4c6
                    // each of those util.stream.ReferencePipeline represents the array lists first declared above

                .forEach(System.out::println);
    }

}
