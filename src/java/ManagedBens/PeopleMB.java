package ManagedBens;

import Models.People;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="people")
@SessionScoped
public class PeopleMB {

    public PeopleMB() {
    
    }
    
    public People getPeople(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        People people = (People)session.getAttribute("people_passport");
        return people;
    }
    
    public boolean getAuthenticate() {
        boolean result = false;
        if (getPeople() != null) {
            result = true;
        }
        return result;
    }
}
