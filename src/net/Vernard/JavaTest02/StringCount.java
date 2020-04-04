package net.Vernard.JavaTest02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringCount {
    // this will compare strings, store the strings in a list, and output the list in an order by length of strings.
      public static void main(String... args) {
//
          // Older comparator method...
//        Comparator<String> comp = new Comparator<String>() {
//
//            @Override
//            public int compare(String s1, String s2) {
//
//                return Integer.compare(s1.length(), s2.length());
//            }
//        };

          // Old (previous) comparator Lambda method...
          // Comparator<String> comp = (String s1, String s2) ->
          //                Integer.compare(s1.length(), s2.length());
          // or // ==========
          // Comparator<String> comp = (s1, s2) ->
          //                Integer.compare(s1.length(), s2.length());

        // Preferred method reference
        Comparator<String> comp = Comparator.comparingInt(String::length);

        List<String> list = Arrays.asList("Czechoslovakia", "Kalaadlitnunaat", "Schmedeswurtherwesterdeich", "Kirkjubæjarklaustur");
        list.sort(comp);

        //this
//        for(String s : list) {
//            System.out.println(s);
//        }

          //or
          list.forEach(System.out::println);
    }
}
