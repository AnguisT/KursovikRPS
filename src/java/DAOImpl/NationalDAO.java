package DAOImpl;

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
    private National nationals;
    
    public NationalDAO(Connection con) {
        this.con = con;
    }
    
    public National getNationals() throws SQLException, IOException {
        National national = new National();
        String query = "select * from National, People where National.NumberPassportN = People.NumberPassport;";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            People p = new People();
            p.setNumberPassport(rs.getLong(3));
            p.setDateOfBirthday(rs.getString(4));
            p.setFirstName(rs.getString(5));
            p.setSecondName(rs.getString(6));
            p.setMiddleName(rs.getString(7));
            national.setNumberPassportN(rs.getLong(1));
            national.setNumberAttempts(rs.getInt(2));
            national.setPeople(p);
        }
        rs.close();
        return national;
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
