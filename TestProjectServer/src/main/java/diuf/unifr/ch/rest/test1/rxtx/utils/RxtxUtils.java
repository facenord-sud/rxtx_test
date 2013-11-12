/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.rxtx.utils;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import diuf.unifr.ch.rest.test1.jaxb.AbstractComponent;
import diuf.unifr.ch.rest.test1.rxtx.ArduinoCommunication;
import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import java.lang.reflect.Type;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leo
 */
public class RxtxUtils {
    
    private ArduinoCommunication aCom;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RxtxUtils.class);
    
    public RxtxUtils() {
        aCom = new ArduinoCommunication();
    }
    
    public <T> T getComponent(Class type, TinkerShield pin) {
        JsonObject jComponent = aCom.read(pin.toString());
        if(jComponent == null) {
            return null;
        }
        AbstractComponent ret_value = (AbstractComponent) aCom.getGson().fromJson(jComponent, type);
        ret_value.setPin(pin);
        return (T) type.cast(ret_value);
    }
    
    public void setComponent(AbstractComponent component) {
        JsonObject jComponent = new JsonObject();
        jComponent.add(component.getPin().toString(), aCom.getGson().toJsonTree(component));
        aCom.write(jComponent);
    }
}
