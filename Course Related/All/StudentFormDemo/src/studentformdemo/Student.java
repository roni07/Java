/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentformdemo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mehedi
 */
public class Student {
    private String id ;
    private String name ;
    private LocalDate date ;
    private ArrayList<String> colaborateDetails ;
    
    public Student(){
        colaborateDetails = new ArrayList() ;
    }

    public Student(String id, String name, LocalDate date) {
        this() ;
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public ArrayList<String> getColaborate(){
        return colaborateDetails ;
    }

    @Override
    public String toString() {
        return id ;
    }
    
    
}
