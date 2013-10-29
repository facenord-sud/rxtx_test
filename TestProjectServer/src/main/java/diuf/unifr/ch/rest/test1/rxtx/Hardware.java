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
public enum Hardware {
    
    LED("led");
    
    private final String value;
    
    private Hardware(String value) {
        this.value = value;
    }
}
