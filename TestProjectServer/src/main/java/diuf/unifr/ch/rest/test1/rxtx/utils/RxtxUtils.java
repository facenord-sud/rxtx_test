/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.rxtx.utils;

import com.google.gson.reflect.TypeToken;
import diuf.unifr.ch.rest.test1.jaxb.AbstractComponent;
import diuf.unifr.ch.rest.test1.rxtx.ArduinoCommunication;
import java.lang.reflect.Type;
import java.util.Map;

/**
 *
 * @author leo
 */
public class RxtxUtils {
    
    private ArduinoCommunication aCom;
    
    public RxtxUtils() {
        aCom = new ArduinoCommunication();
    }
    
    public <T> T getComponent(Class type, int pin) {
        Map<String, String> map = aCom.read();
        if(!map.containsKey(String.valueOf(pin))) {
            return null;
        }
        AbstractComponent ret_value = (AbstractComponent) aCom.getGson().fromJson(map.get(String.valueOf(pin)), type);
        ret_value.setPin(pin);
        return (T) type.cast(ret_value);
    }
    
    public void setComponent(AbstractComponent component) {
        Map<String, String> map = aCom.read();
        map.put(String.valueOf(component.getPin()), aCom.getGson().toJson(component));
        aCom.write(component);
    }
}
