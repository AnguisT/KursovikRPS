/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Models.People;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Владислав
 */
public class PeopleDAO {
    
    ArrayList<People> resume;
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public PeopleDAO(Connection con) {
        this.con = con;
    }
    
    public People getPeople(Long numberpassport) throws SQLException {
        People people = new People();
        String query = "select * from People where NumberPassport = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setLong(1, numberpassport);        
        rs = pstmt.executeQuery();
        while (rs.next()) {
            people.setNumberPassport(rs.getLong(1));
            people.setDateOfBirthday(rs.getString(2));
            people.setSecondName(rs.getString(4));
            people.setMiddleName(rs.getString(5));
        }
        return people;
    }
    
//    public List<Resume> getAllResume() throws SQLException, IOException {
//        resume = new ArrayList<>();
//        String query = "select * from resume";
//        pstmt = con.prepareStatement(query);
//        rs = pstmt.executeQuery();
//        while (rs.next()) {
//            People p = new People();
//            p.setNumberPassport(rs.getInt(1));
//            p.setDateOfBirthday(rs.getString(2));
//            p.set(rs.getInt(3));
//            p.setDateCreate(rs.getDate(4));
//            resume.add(r);
//        }
//        rs.close();
//        return resume;
//    }
}
