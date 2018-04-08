/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import req.facade.RequestsFacadeLocal;

import req.entities.Requests;

/**
 *
 * @author Tomi
 */
@Named(value = "requestList")
@RequestScoped
public class RequestList {

    @Inject
    private RequestsFacadeLocal requestsFacade;

    private String newRequest;

    private HtmlDataTable requestDataTable;

    public void addRequest() {
        Requests requests = new Requests();
        requests.setRequestDate(Date.from(Instant.now()));
        requests.setRequestText(newRequest);
        requestsFacade.create(requests);
    }

    public void deleteRequest() {
        Requests req = (Requests) requestDataTable.getRowData();
        requestsFacade.remove(req);
    }

    /**
     * Get the value of requestDataTable
     *
     * @return the value of requestDataTable
     */
    public HtmlDataTable getRequestDataTable() {
        return requestDataTable;
    }

    /**
     * Set the value of requestDataTable
     *
     * @param requestDataTable new value of requestDataTable
     */
    public void setRequestDataTable(HtmlDataTable requestDataTable) {
        this.requestDataTable = requestDataTable;
    }

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    /**
     * Creates a new instance of RequestList
     */
    public RequestList() {
    }

    public List<Requests> getAllRequests() {
        return requestsFacade.findAll();
    }

}
