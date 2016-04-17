package ua.ronaldo173.library.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Santer on 17.04.2016.
 */
@ManagedBean
@SessionScoped
public class LocaleChanger implements Serializable {

    private Locale currLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public void changeLocale(String localeCode) {
        currLocale = new Locale(localeCode);
    }

    public Locale getCurrLocale() {
        return currLocale;
    }
}
