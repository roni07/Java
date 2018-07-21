package hometask;

public class Hometask {

    private static double add = 0.0;

    public static void task1() {
 
        int numbers[] = {12, 30, 51, 20, 5, 4};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.printf("Average = %.3f\n", average);
    }

    public static void task2() {

        int numbers[] = {4, 6, 1, 2, 8, 9, 3};
        int min = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        System.out.printf("Minmum = %d\n", min);
    }

    public static void task3() {

        int numbers[] = {4, 6, 2, 8, 3, 7, 10};
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        System.out.printf("Maximum = %d\n", max);
    }

    public static void task4() {
        
        int numbers[] = {12,4,9,7,6,5,8,1};
        int n = 0;
        double av;
        double sum;

        for (int i = 0; i < numbers.length; i++) 
            n = n + numbers[i];
        
        av = (double) n / numbers.length;
        

        for (int j = 0; j <  numbers.length; j++) 
        {
            sum =  numbers[j] - av;
            add = add + Math.pow(sum, 2);
        }
        
        System.out.printf("Standard Daveation = %.3f\n", Math.sqrt((add/( numbers.length -1))));
    }

    public static void task5() {

        int numbers[] = {12, 30, 51, 20, 5, 4};
        double geommen;
        double product = 1;

        for (int i = 0; i < numbers.length; i++) 
        {
            product = product * numbers[i];
        }

        geommen = Math.pow(product, (double) 1 / numbers.length);

        System.out.printf("Geometric Mean = %.3f\n", geommen);
    }

    public static void task6() {

        int numbers[] = {12, 5, 2, 6, 7, 8};
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        int min = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        int lrgdis = max - min;

        System.out.printf("Largest Distance = %d\n", lrgdis);

    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

}
