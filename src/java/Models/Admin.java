package Models;

public class Admin {
    
    private Long NumberPassportA;
    private String Communication;
    
    private People people;

    /**
     * @return the NumberPassportA
     */
    public Long getNumberPassportA() {
        return NumberPassportA;
    }

    /**
     * @param NumberPassportA the NumberPassportA to set
     */
    public void setNumberPassportA(Long NumberPassportA) {
        this.NumberPassportA = NumberPassportA;
    }

    /**
     * @return the Communication
     */
    public String getCommunication() {
        return Communication;
    }

    /**
     * @param Communication the Communication to set
     */
    public void setCommunication(String Communication) {
        this.Communication = Communication;
    }

    /**
     * @return the people
     */
    public People getPeople() {
        return people;
    }

    /**
     * @param people the people to set
     */
    public void setPeople(People people) {
        this.people = people;
    }
}
