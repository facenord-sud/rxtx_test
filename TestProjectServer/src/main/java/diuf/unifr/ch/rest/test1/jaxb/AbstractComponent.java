/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.jaxb;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author leo
 */
public abstract class AbstractComponent {
    
    private int pin;

    @XmlAttribute
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
