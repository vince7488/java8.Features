package net.Vernard.JavaTest02;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateStreams {

    public static void main(String[] args) {
        // this program gets an array stream, and filter them by predicates
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        //predicates for filters; predicates are like variables for operations
        Predicate<String> set1 = s -> s.length() > 3 ;
        Predicate<String> set2 = Predicate.isEqual("two");
        Predicate<String> set3 = s -> s.contains("r");

        // streams are the ones that processes the predicates
        stream
                .filter(set1.or(set2).and(set3))
                .forEach(s -> System.out.println(s));
    }

}
