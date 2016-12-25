package Models;

public class Bulletin {
    
    private int idBulliten;
    private Long NumberPassportN;
    private Long NumberPassportC;
    
    private National national;
    private Candidate candidate;

    /**
     * @return the idBulliten
     */
    public int getIdBulliten() {
        return idBulliten;
    }

    /**
     * @param idBulliten the idBulliten to set
     */
    public void setIdBulliten(int idBulliten) {
        this.idBulliten = idBulliten;
    }

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
     * @return the national
     */
    public National getNational() {
        return national;
    }

    /**
     * @param national the national to set
     */
    public void setNational(National national) {
        this.national = national;
    }

    /**
     * @return the candidate
     */
    public Candidate getCandidate() {
        return candidate;
    }

    /**
     * @param candidate the candidate to set
     */
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
