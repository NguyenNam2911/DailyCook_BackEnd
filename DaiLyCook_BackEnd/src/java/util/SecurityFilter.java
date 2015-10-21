/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.User;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP 8470P
 */
public class SecurityFilter implements PhaseListener {

  

    @Override
    public void beforePhase(PhaseEvent event) {
       

    
    }
    

    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        boolean loginPage = fc.getViewRoot().getViewId().lastIndexOf("login")
                > -1;
        if (!loginPage && !isUserLogged()) {
            navigate(event, "logout");
        }
    }

   
    

    private boolean isUserLogged() {
        //looks session for user
        HttpSession session = JSFutil.getSession();
        User user = (User) session.getAttribute("user");
        return user != null;
    }

    private void navigate(PhaseEvent event, String page) {
        FacesContext fc = event.getFacesContext();
        NavigationHandler nh = fc.getApplication().getNavigationHandler();
        nh.handleNavigation(fc, null, page);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
