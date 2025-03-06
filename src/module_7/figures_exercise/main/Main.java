package module_7.figures_exercise.main;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        StringJoiner sjWithPrefixSuffix = new StringJoiner(", ", "[", "]");
        sjWithPrefixSuffix.add("Apple");
        sjWithPrefixSuffix.add("Banana");
        sjWithPrefixSuffix.add("Cherry");

        System.out.println(sjWithPrefixSuffix.toString());  // [Apple, Banana, Cherry]

    }
}
