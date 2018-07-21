package MemberList;

public class Members {

    private String name;
    private String phnNum;


    public Members(String name, String phnNum) {
        this.name = name;
        this.phnNum = phnNum;

    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phnNum;
    }

    @Override
    public String toString() {
        return name ;
    }


    
    

}
