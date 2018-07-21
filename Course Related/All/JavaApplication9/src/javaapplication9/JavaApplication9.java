package javaapplication9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mehedi
 */
public class JavaApplication9 {

    public static void main(String[] args) throws IOException {
        try {
            RandomAccessFile input = new RandomAccessFile("studentFile.txt", "r");
            while(true)
            {
                String line = input.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaApplication9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
