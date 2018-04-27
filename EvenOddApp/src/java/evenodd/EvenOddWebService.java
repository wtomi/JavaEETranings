/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenodd;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Tomi
 */
@WebService(serviceName = "EvenOddWebService")
public class EvenOddWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isEven")
    public boolean isEven(@WebParam(name = "val") int val) {
        return val % 2 == 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isOdd")
    public boolean isOdd(@WebParam(name = "val") int val) {
        //TODO write your implementation code here:
        return !isEven(val);
    }
}
