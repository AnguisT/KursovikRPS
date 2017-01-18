package ManagedBens;

import DAOImpl.CandidateDAO;
import DAOImpl.InformationCandidateDAO;
import Models.Candidate;
import Models.People;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@ManagedBean(name = "fileMB")
@RequestScoped
public class UploadFileMB {

    private static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private Part fileImg;
    private Part fileVideo;
    public People people;
    public Candidate candidate;
    private InformationCandidateDAO ic;
    private CandidateDAO cand;
    
    public UploadFileMB() {
    }
    
    @PostConstruct
    public void init() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Kursrps");
            Connection conn = ds.getConnection();
            ic = new InformationCandidateDAO(conn);
            cand = new CandidateDAO(conn);
        } catch (NamingException | SQLException e) {
            
        }
    }
    
    public void uploadFile() throws IOException, SQLException {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        String context = facesContext.getExternalContext().getRequestContextPath();
        if (fileImg != null) {
            String filename = getFilename(fileImg);
            String nameImg = randomFileName(filename);
            String contextpath = "C:\\Users\\Владислав\\Documents\\NetBeansProjects\\Kursrps\\web\\Images\\" + nameImg;
            fileImg.write(contextpath);
            updateImg(nameImg);
        } 
        if (fileVideo != null) {
            String filename = getFilename(fileVideo);
            String nameVideo = randomFileName(filename);
            String contextpath = "C:\\Users\\Владислав\\Documents\\NetBeansProjects\\Kursrps\\web\\Videos\\" + nameVideo;
            fileVideo.write(contextpath);
            updateVideo(nameVideo);
        }
    }
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
    
    public String randomFileName(String fname) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String[] name = fname.split("\\.");
        int length = random.nextInt(15)+25;
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        name[0] = sb.toString();
        String output = name[0] + "." + name[1];
        return output;
    }

    public void updateImg(String ImgName) throws SQLException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        people = (People)session.getAttribute("people_passport");
        candidate = cand.getCandidate(people);
        ic.updateImgInform(ImgName, candidate);
    }
    
    public void updateVideo(String VideoName) throws SQLException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        people = (People)session.getAttribute("people_passport");
        candidate = cand.getCandidate(people);
        ic.updateVideoInform(VideoName, candidate);
    }
    
    public Part getFileImg() {
        return fileImg;
    }

    public void setFileImg(Part fileImg) {
        this.fileImg = fileImg;
    }

    public Part getFileVideo() {
        return fileVideo;
    }

    public void setFileVideo(Part fileVideo) {
        this.fileVideo = fileVideo;
    }
}
