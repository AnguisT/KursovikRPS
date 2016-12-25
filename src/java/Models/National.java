package Models;

public class National {
    
    private Long NumberPassportN;
    private Long NumberAttempts;
    
    private People people;

    /**
     * @return the NumberPassportN
     */
    public Long getNumberPassportN() {
        return NumberPassportN;
    }

    /**
     * @param NumberPassportN the NumberPassportN to set
     */
    public void setNumberPassportN(Long NumberPassportN) {
        this.NumberPassportN = NumberPassportN;
    }

    /**
     * @return the NumberAttempts
     */
    public Long getNumberAttempts() {
        return NumberAttempts;
    }

    /**
     * @param NumberAttempts the NumberAttempts to set
     */
    public void setNumberAttempts(Long NumberAttempts) {
        this.NumberAttempts = NumberAttempts;
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
