package Validator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="fileImgValidator")
public class FileImgValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Part file = (Part) o;
        FacesMessage message=null;
        try {
            
            if (file == null) 
            {
                message=new FacesMessage("Вы не выбрали картинку");
            } 
            else 
            {
                if ((!file.getContentType().endsWith("png")) && (!file.getContentType().endsWith("jpg")) && (!file.getContentType().endsWith("jpeg")))
                {
                    message=new FacesMessage("Выберете разрешение картинки PNG, JPG, JPEG");
                }
            }           
                        
            if (file.getSize()>2000000)
            {
                message=new FacesMessage("Картинка слишком много весит. Размер картинки не должен быть больше 2 MB.");
            }
            
            if (message!=null && !message.getDetail().isEmpty())
            {
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } catch (Exception ex) {
               throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
    }
}
