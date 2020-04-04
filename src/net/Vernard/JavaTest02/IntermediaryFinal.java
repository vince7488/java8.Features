package net.Vernard.JavaTest02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryFinal {

    public static void main(String[] args) {

        // initialize an array
        Stream<String> stream = Stream.of("Alpha Sierra", "Hotel", "Lima", "Echo","Yankee","X-ray");

        //predicate operations
        Predicate<String> p1 = Predicate.isEqual("Lima");
        Predicate<String> p2 = s -> s.contains("a");
        Predicate<String> p3 = s -> s.length() >= 5;

        //initialize list
        List<String> list = new ArrayList<>();

        //stream it
        stream
                //this will demonstrate how intermediary stream is processed and final is processed
                .peek(System.out::println) // peek on stream first (prints ALL)
                .filter(p1.or(p2).or(p3)) // because the filter happens after peek, none of the filter is shown
                .forEach(list::add); // foreach adds the filtered entities to list (to count them, below) (FINAL)

        System.out.println("Intermediary Done!"); //prints DONE after intermediary
        System.out.println("Printing Final: size = " + list.size());  // prints the size of FILTERED entities (FINAL)
    }

}
