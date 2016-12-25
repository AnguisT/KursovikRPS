/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBens;

import DAOImpl.CandidateDAO;
import Models.Candidate;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Владислав
 */
@ManagedBean(name="candidateMB")
@SessionScoped
public class CandidateMB {

    private List<Candidate> candidates;
    private CandidateDAO cand;
    
    public CandidateMB() {
    }
    
    @PostConstruct
    public void init() {
        try 
        {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/kursrps");
            Connection conn = ds.getConnection();
            cand = new CandidateDAO(conn);
        } 
        catch (NamingException | SQLException e)
        {}
    }
    
    public List<Candidate> getCandidate() throws SQLException, IOException {
        return cand.getAllCandidate();
    }
}
