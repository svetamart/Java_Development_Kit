public class Calculator {

    public static <T extends Number, U extends Number> double sum(T a, U b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null values are not accepted");
        }
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null values are not accepted");
        }
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null values are not accepted");
        }
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T a, U b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Null values are not accepted");
        }
        return a.doubleValue() - b.doubleValue();
    }
}
