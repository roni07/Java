
package inputoutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Inputoutput {
    
    private void toWrite()
    {
        try{
            RandomAccessFile randomAccessFile = new RandomAccessFile("mehedi.txt", "rw");
            randomAccessFile.setLength(0);
            randomAccessFile.writeBytes("sajhgjfhytrhdhtfhfh");
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not Found!");
        }
        catch(IOException ioe)
        {
            System.out.println("tyty");
        }
    }
    
    public Inputoutput()
    {
        toWrite();
    }
    
    
    public static void main(String[] args) {
        new Inputoutput();
    }
    
}
