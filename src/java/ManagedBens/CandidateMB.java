package ManagedBens;

import DAOImpl.CandidateDAO;
import DAOImpl.InformationCandidateDAO;
import Models.Candidate;
import Models.People;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@ManagedBean(name = "candidateMB")
@SessionScoped
public class CandidateMB {

    private List<Candidate> candidates;
    private Candidate candidate;
    private CandidateDAO cand;
    private InformationCandidateDAO ic;
    private String description;
    private People people;
    
    public CandidateMB() {
    }

    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            cand = new CandidateDAO(conn);
            ic = new InformationCandidateDAO(conn);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void updateDesInform() throws SQLException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        people = (People)session.getAttribute("people_passport");
        candidate = cand.getCandidate(people);
        ic.updateDescription(description, candidate);
    }
}
