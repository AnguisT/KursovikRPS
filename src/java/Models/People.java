package Models;

public class People {
    
    private Long NumberPassport;
    private String DateOfBirthday;
    private String FirstName;
    private String SecondName;
    private String MiddleName;

    /**
     * @return the NumberPassport
     */
    public Long getNumberPassport() {
        return NumberPassport;
    }

    /**
     * @param NumberPassport the NumberPassport to set
     */
    public void setNumberPassport(Long NumberPassport) {
        this.NumberPassport = NumberPassport;
    }

    /**
     * @return the DateOfBirthday
     */
    public String getDateOfBirthday() {
        return DateOfBirthday;
    }

    /**
     * @param DateOfBirthday the DateOfBirthday to set
     */
    public void setDateOfBirthday(String DateOfBirthday) {
        this.DateOfBirthday = DateOfBirthday;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the SecondName
     */
    public String getSecondName() {
        return SecondName;
    }

    /**
     * @param SecondName the SecondName to set
     */
    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    /**
     * @return the MiddleName
     */
    public String getMiddleName() {
        return MiddleName;
    }

    /**
     * @param MiddleName the MiddleName to set
     */
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }
}
