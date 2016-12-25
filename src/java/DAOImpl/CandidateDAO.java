/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import Models.People;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Models.Candidate;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import Models.InformationCandidate;

/**
 *
 * @author Владислав
 */
public class CandidateDAO {
    
    ArrayList<Candidate> candidates;
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public CandidateDAO(Connection con) {
        this.con = con;
    }
    
    public List<Candidate> getAllCandidate() throws SQLException, IOException {
        candidates = new ArrayList<>();
        String query = "select * from Candidate, InformationCandidate, People where Candidate.NumberPassportC = People.NumberPassport and Candidate.idInformationVoter = InformationCandidate.idInformationCandidate";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Candidate c = new Candidate();
            People p = new People();
            InformationCandidate ic = new InformationCandidate();
            p.setFirstName(rs.getString(9));
            p.setSecondName(rs.getString(10));
            p.setMiddleName(rs.getString(11));
            ic.setNumberVoter(rs.getInt(4));
            ic.setPlaceInList(rs.getInt(5));
            ic.setDescription(rs.getString(6));
            c.setPeople(p);
            c.setInformationcandidate(ic);
            candidates.add(c);
        }
        rs.close();
        return candidates;
    }
}
