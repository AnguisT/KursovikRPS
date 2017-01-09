package DAOImpl;

import Models.Candidate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BulletinDAO {
    
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public BulletinDAO(Connection con) {
        this.con = con;
    }
    
    public void Vote(Long numberpassport, Candidate candidate) throws SQLException {
        pstmt = con.prepareStatement("insert into bulletin (NumberPassportN, NumberPassportC) values (?, ?);");
        pstmt.setLong(1, numberpassport);
        pstmt.setLong(2, candidate.getNumberPassportC());
        pstmt.executeUpdate();
    }
}
