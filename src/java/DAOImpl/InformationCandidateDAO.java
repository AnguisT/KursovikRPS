package DAOImpl;

import Models.Candidate;
import Models.People;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InformationCandidateDAO {
    
    private static Connection con;
    private static PreparedStatement pstmt;
    
    public InformationCandidateDAO(Connection conn) {
        this.con = conn;
    }
    
    public void plusVoice(Candidate candidate) throws SQLException {
        int number = candidate.getInformationcandidate().getNumberVoter();
        ++number;
        pstmt = con.prepareStatement("UPDATE Informationcandidate set NumberVoter = ? WHERE idInformationCandidate = ?;");
        pstmt.setInt(1, number);
        pstmt.setInt(2, candidate.getIdInformationVoter());
        pstmt.executeUpdate();
    }
    
    public void updateImgInform(String fileimgname, Candidate candidate) throws SQLException {
        pstmt = con.prepareStatement("UPDATE InformationCandidate set NameImage = ? WHERE idInformationCandidate = ?;");
        pstmt.setString(1, fileimgname);
        pstmt.setInt(2, candidate.getIdInformationVoter());
        pstmt.executeUpdate();
    }
    
    public void updateVideoInform(String filevideoname, Candidate candidate) throws SQLException {
        pstmt = con.prepareStatement("UPDATE InformationCandidate set NameVideo = ? WHERE idInformationCandidate = ?;");
        pstmt.setString(1, filevideoname);
        pstmt.setInt(2, candidate.getIdInformationVoter());
        pstmt.executeUpdate();
    }
    
    public void updateDescription(String description, Candidate candidate) throws SQLException {
        pstmt = con.prepareStatement("UPDATE InformationCandidate set Description = ? WHERE idInformationCandidate = ?;");
        pstmt.setString(1, description);
        pstmt.setInt(2, candidate.getIdInformationVoter());
        pstmt.executeUpdate();
    }
}
