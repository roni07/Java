package amirhamzah;

public class Student {

    private String id;
    private String name;
    private String fullName;
    private String contactNumber;

    public Student(String id, String name, String fullName, String contactNumber) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Student ID = " + id + ", Name = " + name + ", Full Name = " + fullName + ", Contact Number = " + contactNumber +"\n";
    }
    
    
}
