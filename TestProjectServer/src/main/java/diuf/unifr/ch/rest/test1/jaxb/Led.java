/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.jaxb;

import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@XmlRootElement
public class Led extends AbstractComponent{
    
    private boolean isBlinking;
    private boolean isLighting;
    private boolean isOn;
    
    @XmlElement
    public boolean isIsBlinking() {
        return isBlinking;
    }

    public void setIsBlinking(boolean isBlinking) {
        this.isBlinking = isBlinking;
    }

    @XmlElement
    public boolean isIsLighting() {
        return isLighting;
    }

    public void setIsLighting(boolean isLighting) {
        this.isLighting = isLighting;
    }

    @XmlElement
    public boolean isIsOn() {
        return isOn;
    }
    
    
}