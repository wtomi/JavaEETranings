/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.time.LocalDateTime;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tomi
 */
@ManagedBean
public class FormBean {

    private int firstElement;
    private int secondElement;
    private int additionResult;

    public void performAddition() {
        additionResult = firstElement + secondElement;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("", firstElement + " + " + secondElement + " = " + additionResult));
    }

    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    /**
     * @return the firstElement
     */
    public int getFirstElement() {
        return firstElement;
    }

    /**
     * @param firstElement the firstElement to set
     */
    public void setFirstElement(int firstElement) {
        this.firstElement = firstElement;
    }

    /**
     * @return the secondElement
     */
    public int getSecondElement() {
        return secondElement;
    }

    /**
     * @param secondElement the secondElement to set
     */
    public void setSecondElement(int secondElement) {
        this.secondElement = secondElement;
    }

    /**
     * @return the additionResult
     */
    public int getAdditionResult() {
        return additionResult;
    }

    /**
     * @param additionResult the additionResult to set
     */
    public void setAdditionResult(int additionResult) {
        this.additionResult = additionResult;
    }

}
