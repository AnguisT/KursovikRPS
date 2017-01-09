package Models;

public class InformationCandidate {
    
    private int idInformationCandidate;
    private int NumberVoter;
    private int PlaceInList;
    private String Description;
    private String NameImage;
    private String NameVideo;

    public int getIdInformationCandidate() {
        return idInformationCandidate;
    }

    public void setIdInformationCandidate(int idInformationCandidate) {
        this.idInformationCandidate = idInformationCandidate;
    }

    public int getNumberVoter() {
        return NumberVoter;
    }

    public void setNumberVoter(int NumberVoter) {
        this.NumberVoter = NumberVoter;
    }

    public int getPlaceInList() {
        return PlaceInList;
    }

    public void setPlaceInList(int PlaceInList) {
        this.PlaceInList = PlaceInList;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getNameImage() {
        return NameImage;
    }

    public void setNameImage(String NameImage) {
        this.NameImage = NameImage;
    }

    public String getNameVideo() {
        return NameVideo;
    }

    public void setNameVideo(String NameVideo) {
        this.NameVideo = NameVideo;
    }
}
