package amirhamzah;

import java.util.ArrayList;
import java.util.List;

public class AmirHamzaMilon {

    public static void main(String[] args) {
        List<Student> studentInfo = new ArrayList<>();

        Student mine = new Student("2016000000242", "Hamzah", "Amir Hamzah", "01708-119956");
        Student roni = new Student("2016000000004", "Roni", "Md. Mehedi Hasan", "01932726128");
        Student ali = new Student("2016000000244", "Ali", "Ali Hasan", "01926-119286");

        studentInfo.add(mine);
        studentInfo.add(roni);
        studentInfo.add(ali);
        System.out.println(studentInfo);
    }

}
