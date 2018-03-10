/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Tomi
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckBox;
    private HtmlCommandButton loginButton;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String login() {
        if (getUsername().equals(getPassword())) {
            return "success.xhtml";
        } else {
            return "failure.xhtml";
        }
    }

    public void activateButton(ValueChangeEvent event) {
        if (acceptCheckBox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the acceptCheckBox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckBox() {
        return acceptCheckBox;
    }

    /**
     * @param acceptCheckBox the acceptCheckBox to set
     */
    public void setAcceptCheckBox(HtmlSelectBooleanCheckbox acceptCheckBox) {
        this.acceptCheckBox = acceptCheckBox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

}
