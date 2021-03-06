package ua.ronaldo173.library.web.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.ResourceBundle;

@FacesValidator("LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        ResourceBundle bundle = ResourceBundle.getBundle("ua.ronaldo173.library.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());

        try {
            String newValue = value.toString();

            if (newValue.length() < 3) {
                throw new IllegalArgumentException(bundle.getString("login_length_error"));
            }

            if (!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(bundle.getString("login_start_from_num_error"));
            }

            if (getTestArray().contains(newValue)) {
                throw new IllegalArgumentException(bundle.getString("login_already_exists_error"));
            }


        } catch (IllegalArgumentException e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }

    private ArrayList<String> getTestArray() {
        ArrayList<String> list = new ArrayList<String>();// заглушка, желательно делать запрос в базу данных для проверки существующего имени
        list.add("username");
        list.add("login");
        return list;
    }

}
