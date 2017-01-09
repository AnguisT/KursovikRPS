package ManagedBens;

import DAOImpl.NationalDAO;
import Models.National;
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

@ManagedBean(name = "nationalMB")
@SessionScoped
public class NationalMB {

    private List<National> nationals;
    private National national;
    private NationalDAO nat;
    
    public NationalMB() {
    }
    
    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            nat = new NationalDAO(conn);
        } catch (NamingException | SQLException e) {
        }
    }

    public List<National> getNationals() throws SQLException, IOException {
        return nat.getAllNationals();
    }
    
}
