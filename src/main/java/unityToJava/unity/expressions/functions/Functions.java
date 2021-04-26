package unityToJava.unity.expressions.functions;

import com.google.common.collect.ImmutableList;

import java.util.Random;

//built_in functions
public class Functions {

    static Random random = new Random();

    public static final String ADD = "add";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String ODD = "odd";
    public static final String EVEN = "even";
    public static final String RANDOM = "rand";
    public static final String FIBONACCI = "fib";

    private static final ImmutableList<String> builtInFunctions = ImmutableList.of(ADD, MIN, MAX, ODD, EVEN, RANDOM, FIBONACCI);

    public static boolean functionExists(String functionName){
        return builtInFunctions.contains(functionName);
    }

    public static int add(int value1, int value2){
        return value1 + value2;
    }

    public static int add(){
        return 0;
    }


    public static int min(int[] values){
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            if (value < min) min = value;
        }
        return min;
    }

    public static int max(int[] values){
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max) max = value;
        }
        return max;
    }

    public static boolean even(int value){
        return (value % 2 == 0);
    }

    public static boolean odd(int value){
        return !even(value);
    }

    public static int random(){
       return random.nextInt();
    }

    public static int random(int upperBound){
        return random.nextInt(upperBound);
    }

    public static int random(int lowerBound, int upperBound){
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static boolean randomBool() {
        return random(2) == 0;
    }

    public static int fib(int num) {
        if (num <= 1)
            return num;
        return fib(num-1) + fib(num-2);
    }
}
