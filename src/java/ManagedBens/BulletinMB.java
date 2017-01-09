package ManagedBens;

import DAOImpl.BulletinDAO;
import DAOImpl.InformationCandidateDAO;
import DAOImpl.NationalDAO;
import Models.Candidate;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name = "bulletin")
@SessionScoped
public class BulletinMB {

    BulletinDAO bull;
    NationalDAO nat;
    InformationCandidateDAO ic;
    
    public BulletinMB() {
        
    }
    
    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            bull = new BulletinDAO(conn);
            nat = new NationalDAO(conn);
            ic = new InformationCandidateDAO(conn);
        } catch (NamingException | SQLException e) {
            
        }
    }
    
    public String Voter(Candidate candidate) throws SQLException, IOException {
        String result;
        if (nat.getAttemps() > 0) {
            String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            long numberpassport = Long.parseLong(username);
            nat.giveVoice(numberpassport);
            ic.plusVoice(candidate);
            bull.Vote(numberpassport, candidate);
            result = "Home?faces-redirect=true";
        } else {
            result = "/Error/errorVoter.xhtml?faces-redirect=true";
        }
        return result;
    }
}
