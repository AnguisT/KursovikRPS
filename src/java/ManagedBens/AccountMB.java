package ManagedBens;

import DAOImpl.PeopleDAO;
import Models.People;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="account")
@SessionScoped
public class AccountMB {

    private Long Login;
    private Date Password;
    private PeopleDAO pdao;
    
    public AccountMB() {
    
    }

    @PostConstruct
    public void init() {
        try 
        {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            pdao = new PeopleDAO(conn);
        } 
        catch (NamingException | SQLException e)
        {}
    }
    
    public Long getLogin() {
        return Login;
    }

    public void setLogin(Long Login) {
        this.Login = Login;
    }

    public Date getPassword() {
        return Password;
    }

    public void setPassword(Date Password) {
        this.Password = Password;
    }
    
    public String authorization() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (pdao.getCheckPeople(Login, Password).getNumberPassport() != null) {
            People people = pdao.getCheckPeople(Login, Password);
            context.getExternalContext().getSessionMap().put("people_passport", people);
            return "/Main/Home.xhtml?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage("Unknow login, try again"));
            return "Login.xhtml?faces-redirect=true";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/Main/Home.xhtml?faces-redirect=true";
    }
}
