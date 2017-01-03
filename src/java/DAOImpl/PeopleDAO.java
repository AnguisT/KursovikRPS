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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public People getCheckPeople(Long Login, Date Password) throws SQLException {
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        String dateofbirthday = df.format(Password);
        People people = new People();
        String query = "select * from People where NumberPassport = ? and DateOfBirthday = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setLong(1, Login);
        pstmt.setString(2, dateofbirthday);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            people.setNumberPassport(rs.getLong(1));
            people.setDateOfBirthday(rs.getString(2));
            people.setFirstName(rs.getString(3));
            people.setSecondName(rs.getString(4));
            people.setMiddleName(rs.getString(5));
        }
        return people;
    }
}
