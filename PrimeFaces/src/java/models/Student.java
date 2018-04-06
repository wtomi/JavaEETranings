/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.DecimalFormat;

/**
 *
 * @author Tomi
 */
public class Student {

    private String key;
    private String lastName;
    private String firstName;
    private double averageGrade;
    
    private final DecimalFormat format = new DecimalFormat("#.00");    
    
    public Student(String key, String firstAndLastName, double averageGrade) {
        String[] names = firstAndLastName.split("\\s+");
        this.key = key;
        this.firstName = names[0];
        this.lastName = names[1];
        this.averageGrade = averageGrade;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the averageGrade
     */
    public String getAverageGrade() {
        return format.format(averageGrade);
    }

    /**
     * @param averageGrade the averageGrade to set
     */
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

}
