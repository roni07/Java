package randomfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomFile {

    public void writeToFile(){
        try{
           RandomAccessFile output = new RandomAccessFile("todoList.txt","rw") ;
           output.writeBytes("2017-11-19");
        }
        catch(FileNotFoundException fnfe){
            System.out.println("File not found details.txt file !");
        }
        catch(IOException ioe){
            System.out.println("Exceptional things happened");
        }
    }
    
    public RandomFile(){
        writeToFile() ;
    }
    
    public static void main(String[] args) {
          new RandomFile() ;
    }
    
}
