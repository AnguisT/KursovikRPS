package DAOImpl;

import Models.Candidate;
import Models.InformationCandidate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InformationCandidateDAO {
    
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
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
}
