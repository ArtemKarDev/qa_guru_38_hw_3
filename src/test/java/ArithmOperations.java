import org.junit.jupiter.api.Test;

public class ArithmOperations {
    public static int sum(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int division(int a, int b) {return a / b;}
    public static int multiply(int a, int b) {return a * b;}

    public double compareOperations(int a, int b, double x, double y) {

        boolean result1 = a > b;
        boolean result2 = x < y;
        boolean result3 = a >= 10;
        boolean result4 = x <= 7.5;

        System.out.println("a > b: " + result1);
        System.out.println("x < y: " + result2);
        System.out.println("a >= 10: " + result3);
        System.out.println("x <= 7.5: " + result4);

        return a + x * b - y;
    }


    public void overflowExample() {
        byte y = 125;
        for (byte i = 1; i <= 4; i++) {
            ++y;
            System.out.print(" " + y);
        }
    }

    @Test
    public void outputResult(){
        System.out.println("пример суммы " + ArithmOperations.sum(4,5));
        System.out.println("пример разницы " + ArithmOperations.minus(4,5));
        System.out.println("пример частного " + ArithmOperations.division(4,5));
        System.out.println("пример умножения " + ArithmOperations.multiply(4,5));
        System.out.println("пример сравнений ");
        compareOperations(2,3,4.4,8.8);
        System.out.print("пример с переполнением ");
        overflowExample();
    }
}