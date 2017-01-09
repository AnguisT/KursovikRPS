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

@ManagedBean(name = "candidateMB")
@SessionScoped
public class CandidateMB {

    private List<Candidate> candidates;
    private Candidate candidate;
    private CandidateDAO cand;

    public CandidateMB() {
    }

    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            cand = new CandidateDAO(conn);
        } catch (NamingException | SQLException e) {
        }
    }

    public List<Candidate> getCandidates() throws SQLException, IOException {
        return cand.getAllCandidate();
    }
    
    public List<Candidate> getSortCandidates() throws SQLException, IOException {
        return cand.getSortCandidate();
    }

    public void setOneCandidate(List<Candidate> candidate) {
        this.candidates = candidate;
    }

    public List<Candidate> getOneCandidate() {
        return candidates;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
