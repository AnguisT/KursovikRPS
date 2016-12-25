package Models;

public class Candidate {
    
    private Long NumberPassportC;
    private int idInformationVoter;
    
    private People people;
    private InformationCandidate informationcandidate;

    /**
     * @return the NumberPassportC
     */
    public Long getNumberPassportC() {
        return NumberPassportC;
    }

    /**
     * @param NumberPassportC the NumberPassportC to set
     */
    public void setNumberPassportC(Long NumberPassportC) {
        this.NumberPassportC = NumberPassportC;
    }

    /**
     * @return the idInformationVoter
     */
    public int getIdInformationVoter() {
        return idInformationVoter;
    }

    /**
     * @param idInformationVoter the idInformationVoter to set
     */
    public void setIdInformationVoter(int idInformationVoter) {
        this.idInformationVoter = idInformationVoter;
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

    /**
     * @return the informationcandidate
     */
    public InformationCandidate getInformationcandidate() {
        return informationcandidate;
    }

    /**
     * @param informationcandidate the informationcandidate to set
     */
    public void setInformationcandidate(InformationCandidate informationcandidate) {
        this.informationcandidate = informationcandidate;
    }
    
}
