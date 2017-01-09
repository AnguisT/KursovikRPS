package DAOImpl;

import Models.Candidate;
import Models.InformationCandidate;
import Models.National;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public AdminDAO(Connection conn) {
        this.con = conn;
    }
    
    public void deleteCandidate(Candidate candidate) throws SQLException {
        int idInform = candidate.getIdInformationVoter();
        long numberpassport = candidate.getPeople().getNumberPassport();
        pstmt = con.prepareStatement("insert into National(NumberPassportN) values (?)");
        pstmt.setLong(1, numberpassport);
        pstmt.executeUpdate();
        pstmt = con.prepareStatement("delete from Candidate where NumberPassportC = ?");
        pstmt.setLong(1, numberpassport);
        pstmt.executeUpdate();
        pstmt = con.prepareStatement("delete from InformationCandidate where idInformationCandidate = ?");
        pstmt.setInt(1, idInform);
        pstmt.executeUpdate();
    }
    
    public void addCandidate(National national, int PlaceInList) throws SQLException {
        InformationCandidate ic = new InformationCandidate();
        pstmt = con.prepareStatement("insert into InformationCandidate(PlaceInList) values (?)");
        pstmt.setInt(1, PlaceInList);
        pstmt.executeUpdate();
        pstmt = con.prepareStatement("select idInformationCandidate from InformationCandidate where PlaceInList = ?");
        pstmt.setInt(1, PlaceInList);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            ic.setIdInformationCandidate(rs.getInt(1));
        }
        int idInform = ic.getIdInformationCandidate();
        pstmt = con.prepareStatement("insert into Candidate(NumberPassportC, idInformationVoter) values (?, ?)");
        pstmt.setLong(1, national.getPeople().getNumberPassport());
        pstmt.setInt(2, idInform);
        pstmt.executeUpdate();
        pstmt = con.prepareStatement("delete from National where NumberPassportN = ?");
        pstmt.setLong(1, national.getNumberPassportN());
        pstmt.executeUpdate();
        
    }
}
