import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("--Calculator--");

        System.out.println("Sum: " + Calculator.sum(5, 3.5f));
        System.out.println("Multiply: " + Calculator.multiply(6.5, 4));
        System.out.println("Divide: " + Calculator.divide(10L, 45.2f));
        System.out.println("Subtract: " + Calculator.subtract(7.0, 3L));

        System.out.println("\n--Array comparator--");

        Integer[] array1 = {1, 5, 9, 12, 9, 39, 81};
        Integer[] array2 = {1, 5, 9, 12, 9, 39, 81};
        String[] array3 = {"apple", "orange", "peach", "banana"};
        String[] array4 = {"apple", "peach", "banana", "pineapple"};

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Arrays are equal: " + ArrayComparator.compareArrays(array1, array2));

        System.out.println("Array 3: " + Arrays.toString(array3));
        System.out.println("Array 4: " + Arrays.toString(array4));
        System.out.println("Arrays are equal: " + ArrayComparator.compareArrays(array3, array4));

        System.out.println("\n--Pairs--");

        Pair<Integer, String> pair1 = new Pair<>(15, "One");
        System.out.println(pair1);
        Pair<Double, Boolean> pair2 = new Pair<>(7.066, false);
        System.out.println(pair2);


    }
}
