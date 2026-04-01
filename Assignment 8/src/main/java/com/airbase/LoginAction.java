package com.airbase;

import javax.servlet.http.*;
import org.apache.struts.action.*;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

        LoginForm lf = (LoginForm) form;

        request.setAttribute("name", lf.getName());

        return mapping.findForward("success");
    }
}