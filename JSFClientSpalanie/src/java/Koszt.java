/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.xml.ws.WebServiceRef;
import org.tempuri.Spalanie;

/**
 *
 * @author Tomi
 */
@ManagedBean
public class Koszt {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_52722/Spalanie.svc.singlewsdl.wsdl")
    private Spalanie service;
    
    private double dystans;
    
    private double cena;
    
    private double spalanie;
    
    private double koszt;

    /**
     * Creates a new instance of Koszt
     */
    public Koszt() {
    }
    
    public void computeKoszt() {
        koszt = callKoszt(cena, dystans, spalanie);
    }

    private Double callKoszt(java.lang.Double cena, java.lang.Double odleglosc, java.lang.Double spalanie) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.ISpalanie port = service.getBasicHttpBindingISpalanie();
        return port.koszt(cena, odleglosc, spalanie);
    }

    public double getDystans() {
        return dystans;
    }

    public void setDystans(double dystans) {
        this.dystans = dystans;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getSpalanie() {
        return spalanie;
    }

    public void setSpalanie(double spalanie) {
        this.spalanie = spalanie;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }
    
    
    
}
