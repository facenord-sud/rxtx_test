/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.rxtx;

import diuf.unifr.ch.rest.test1.pojo.Led;

/**
 *
 * @author leo
 */
public class SimpleLed extends ArduinoCommunication {

    @Override
    public void setComponent(Object o) {
        o = (Led) o;
        write(o);
    }

    @Override
    public Led getComponent() {
        Led led = getGson().fromJson(getJson(), Led.class);
        return led;
    }
    
}
