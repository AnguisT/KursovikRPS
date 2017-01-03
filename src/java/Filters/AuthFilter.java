package Filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import DAOImpl.PeopleDAO;
import Models.People;

public class AuthFilter implements Filter {
    
    private static final boolean debug = true;
    private PreparedStatement pstmt;
    InitialContext ctx;
    DataSource ds;
    Connection con;
    Statement stmt;
    ResultSet rs;
    PeopleDAO peopledao;

    private FilterConfig filterConfig = null;
    
    public AuthFilter() {
    }        
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (((HttpServletRequest) request).getSession().getAttribute("people_passport") == null) {
            String numberpassport = ((HttpServletRequest) request).getRemoteUser();
            if (numberpassport != null) {        
                People people = new People();
                try {  
                    long passport = Long.parseLong(numberpassport);
                    people = peopledao.getPeople(passport);
                    ((HttpServletRequest) request).getSession()
                        .setAttribute("people_passport", people);
                } catch (SQLException ex) {
                    Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }         
        }
        chain.doFilter(request, response); 
    }    

    @Override
    public void destroy() {      
        this.filterConfig = null;    
    }

    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            con = ds.getConnection();
            peopledao = new PeopleDAO(con);
        } catch (NamingException ex) {
            Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
