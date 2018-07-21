package Student;


public class CurrentSemester {
    private String courseCode;
    private String courseTitle;
    private String section;

    public CurrentSemester(String courseCode, String courseTitle, String section) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.section = section;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return courseCode +courseTitle +section ;
    }
    
    
}
