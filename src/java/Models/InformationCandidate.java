package Models;

public class InformationCandidate {
    
    private int idInformationCandidate;
    private int NumberVoter;
    private int PlaceInList;
    private String Description;

    /**
     * @return the idInformationCandidate
     */
    public int getIdInformationCandidate() {
        return idInformationCandidate;
    }

    /**
     * @param idInformationCandidate the idInformationCandidate to set
     */
    public void setIdInformationCandidate(int idInformationCandidate) {
        this.idInformationCandidate = idInformationCandidate;
    }

    /**
     * @return the NumberVoter
     */
    public int getNumberVoter() {
        return NumberVoter;
    }

    /**
     * @param NumberVoter the NumberVoter to set
     */
    public void setNumberVoter(int NumberVoter) {
        this.NumberVoter = NumberVoter;
    }

    /**
     * @return the PlaceInList
     */
    public int getPlaceInList() {
        return PlaceInList;
    }

    /**
     * @param PlaceInList the PlaceInList to set
     */
    public void setPlaceInList(int PlaceInList) {
        this.PlaceInList = PlaceInList;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
