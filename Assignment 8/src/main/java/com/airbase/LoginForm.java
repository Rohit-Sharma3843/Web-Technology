package com.airbase;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

public class LoginForm extends ActionForm {

    private String name;
    private String mobile;
    private String email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if (name == null || name.trim().equals(""))
            errors.add("name", new ActionMessage("error.name"));
        else if (!name.matches("[A-Za-z ]+"))
            errors.add("name", new ActionMessage("error.name.invalid"));

        if (mobile == null || mobile.trim().equals(""))
            errors.add("mobile", new ActionMessage("error.mobile"));
        else if (!mobile.matches("\\d{10}"))
            errors.add("mobile", new ActionMessage("error.mobile.invalid"));

        if (email == null || email.trim().equals(""))
            errors.add("email", new ActionMessage("error.email"));
        else if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))
            errors.add("email", new ActionMessage("error.email.invalid"));

        return errors;
    }
}