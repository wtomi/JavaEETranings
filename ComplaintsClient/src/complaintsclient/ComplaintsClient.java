/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complaintsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author student
 */
public class ComplaintsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Count: " + count);

        String allComplaints = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints")
                .request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("\n\n" + allComplaints);

        String oneComplaint = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/2")
                .request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("\n\n" + oneComplaint);

        //String modified = oneComplaint.replace("open", "closed");
        String modified = oneComplaint.replace("closed", "open");

        Response response
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/2")
                        .request()
                        .put(Entity.entity(modified, MediaType.APPLICATION_XML));

        String allOpen = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints")
                .request()
                .get(String.class);
        
        oneComplaint = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/2")
                .request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("\n\n" + oneComplaint);

        client.close();
    }

}
