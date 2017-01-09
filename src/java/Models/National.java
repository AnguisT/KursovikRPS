package Models;

public class National {
    
    private Long NumberPassportN;
    private int NumberAttempts;
    
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
    public int getNumberAttempts() {
        return NumberAttempts;
    }

    /**
     * @param NumberAttempts the NumberAttempts to set
     */
    public void setNumberAttempts(int NumberAttempts) {
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
