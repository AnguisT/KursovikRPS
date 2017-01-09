package Models;

public class Candidate {
    
    private Long NumberPassportC;
    private int idInformationVoter;
    
    private People people;
    private InformationCandidate informationcandidate;

    public Long getNumberPassportC() {
        return NumberPassportC;
    }

    public void setNumberPassportC(Long NumberPassportC) {
        this.NumberPassportC = NumberPassportC;
    }

    public int getIdInformationVoter() {
        return idInformationVoter;
    }

    public void setIdInformationVoter(int idInformationVoter) {
        this.idInformationVoter = idInformationVoter;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public InformationCandidate getInformationcandidate() {
        return informationcandidate;
    }

    public void setInformationcandidate(InformationCandidate informationcandidate) {
        this.informationcandidate = informationcandidate;
    }
}
