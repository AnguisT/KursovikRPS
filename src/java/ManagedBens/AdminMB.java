package ManagedBens;

import DAOImpl.AdminDAO;
import Models.Candidate;
import Models.National;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name = "adminMB")
@SessionScoped
public class AdminMB {

    private AdminDAO adm;
    private int PlaceInList;
    
    public AdminMB() {
    }
    
    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            adm = new AdminDAO(conn);
        } catch (NamingException | SQLException e) {
        }
    }
    
    public String deleteCandidate(Candidate candidate) throws SQLException {
        adm.deleteCandidate(candidate);
        return "DeleteCandidate?faces-redirect=true";
    }
    
    public String addCandidate(National national) throws SQLException{
        adm.addCandidate(national, getPlaceInList());
        return "AddCandidate?faces-redirect=true";
    }

    public int getPlaceInList() {
        return PlaceInList;
    }

    public void setPlaceInList(int PlaceInList) {
        this.PlaceInList = PlaceInList;
    }
}
