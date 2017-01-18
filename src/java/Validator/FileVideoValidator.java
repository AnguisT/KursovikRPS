package Validator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="fileVideoValidator")
public class FileVideoValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Part file = (Part) o;
        FacesMessage message=null;
        try {
            if (file==null || file.getSize()<=0 || file.getContentType().isEmpty())
                message=new FacesMessage("Вы не выбрали видео");
            else
            {
                if (!file.getContentType().endsWith("mp4"))
                {
                    message=new FacesMessage("Выберете разрешение видео MP4");
                }
            }
            if (file.getSize()>200000000)
            {
                message=new FacesMessage("Видео слишком много весит. Размер видео не должен быть больше 200 MB.");
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
