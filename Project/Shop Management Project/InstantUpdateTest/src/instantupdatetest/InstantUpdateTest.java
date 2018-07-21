package instantupdatetest;

import java.util.ArrayList;

public class InstantUpdateTest {

    public static void main(String[] args) {
        NewClass n = new NewClass(10);
        ArrayList<Integer> test = new ArrayList<Integer>();
        int p = n.getNumber();
        for (int i = 0; i < 5; i++) { 
            test.add(p);
            p++;
        }
        System.out.println("Before update :" + test);
        int value = 20;
        for (int i = 0; i < test.size(); i++) {
            test.set(i, value);
            value++;
        }
        System.out.println("After update : " + test);
    }

}
