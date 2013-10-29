/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.rxtx;

/**
 *
 * @author leo
 */

public class RequestProtocol {

    
    private String type;
    private TinkerKitShield pin;

    public RequestProtocol(String type, TinkerKitShield pin) {
        this.type = type;
        this.pin = pin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TinkerKitShield getPin() {
        return pin;
    }

    public void setPin(TinkerKitShield pin) {
        this.pin = pin;
    }
    
    
}
