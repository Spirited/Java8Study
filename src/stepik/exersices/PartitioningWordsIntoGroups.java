package stepik.exersices;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class PartitioningWordsIntoGroups {
    public static void main(String[] args) {
        String[] words = {"aaaa", "aaa", "a", "aa"};
        String[] words2 = {"level", "bbaa", "ac"};
        Function<String, Boolean> isPalindrom = (String str) -> {StringBuilder temp = new StringBuilder(str); return str.equals(temp.reverse().toString());};
        Predicate<String> isPalindrom2 = (String str2) -> {StringBuilder temp = new StringBuilder(str2); return str2.equals(temp.reverse().toString());};
        Map<Boolean, List<String>> palindromeOrNoMap = Arrays.stream(words2)
                .collect(partitioningBy(a -> a.equals(new StringBuilder(a).reverse().toString())));

        System.out.println(palindromeOrNoMap);
    }
}
