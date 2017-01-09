package DAOImpl;

import Models.Candidate;
import Models.National;
import Models.People;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NationalDAO {
    
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    List<National> nationals;
    
    public NationalDAO(Connection conn) {
        this.con = conn;
    }
    
    public National getNationals() throws SQLException, IOException {
        National national = new National();
        String query = "select * from National, People where National.NumberPassportN = People.NumberPassport;";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            People p = new People();
            national.setNumberPassportN(rs.getLong(1));
            national.setNumberAttempts(rs.getInt(2));
            p.setNumberPassport(rs.getLong(3));
            p.setDateOfBirthday(rs.getString(4));
            p.setFirstName(rs.getString(5));
            p.setSecondName(rs.getString(6));
            p.setMiddleName(rs.getString(7));
            national.setPeople(p);
        }
        rs.close();
        return national;
    }
    
    public List<National> getAllNationals() throws SQLException, IOException {
        nationals = new ArrayList();
        String query = "select * from National, People where National.NumberPassportN = People.NumberPassport;";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            People p = new People();
            National n = new National();
            n.setNumberPassportN(rs.getLong(1));
            n.setNumberAttempts(rs.getInt(2));
            p.setNumberPassport(rs.getLong(3));
            p.setDateOfBirthday(rs.getString(4));
            p.setFirstName(rs.getString(5));
            p.setSecondName(rs.getString(6));
            p.setMiddleName(rs.getString(7));
            n.setPeople(p);
            nationals.add(n);
        }
        rs.close();
        return nationals;
    }
    
    public int getAttemps () throws SQLException, IOException {
        int attemps = getNationals().getNumberAttempts();
        return attemps;
    }
    
    public void giveVoice(Long numberpassport) throws SQLException {
        pstmt = con.prepareStatement("UPDATE National set NumberAttempts = 0 WHERE NumberPassportN = ?;");
        pstmt.setLong(1, numberpassport);
        pstmt.executeUpdate();
    }
}
