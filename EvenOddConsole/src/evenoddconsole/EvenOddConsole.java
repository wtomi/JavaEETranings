/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenoddconsole;

/**
 *
 * @author Tomi
 */
public class EvenOddConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("isEven(2): " + isEven(2));
        System.out.println("isEven(5): " + isEven(5));
    }

    private static boolean isEven(int val) {
        evenodd.EvenOddWebService_Service service = new evenodd.EvenOddWebService_Service();
        evenodd.EvenOddWebService port = service.getEvenOddWebServicePort();
        return port.isEven(val);
    }
    
    
    
}
