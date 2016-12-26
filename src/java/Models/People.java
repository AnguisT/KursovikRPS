package Models;

public class People {
    
    private Long NumberPassport;
    private String DateOfBirthday;
    private String FirstName;
    private String SecondName;
    private String MiddleName;

    public Long getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(Long NumberPassport) {
        this.NumberPassport = NumberPassport;
    }

    public String getDateOfBirthday() {
        return DateOfBirthday;
    }

    public void setDateOfBirthday(String DateOfBirthday) {
        this.DateOfBirthday = DateOfBirthday;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }
}
