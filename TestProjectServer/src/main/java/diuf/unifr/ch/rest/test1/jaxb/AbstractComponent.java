/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.jaxb;

import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author leo
 */
public abstract class AbstractComponent {
    
    private TinkerShield pin;
    
    public TinkerShield getPin() {
        return pin;
    }
    
    @XmlAttribute
    public int getPinToInt() {
        return pin.toInt();
    }

    public void setPin(TinkerShield pin) {
        this.pin = pin;
    }
}
