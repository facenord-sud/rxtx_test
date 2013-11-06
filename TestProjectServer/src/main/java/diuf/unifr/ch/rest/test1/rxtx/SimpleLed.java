/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.rxtx;

import com.google.gson.reflect.TypeToken;
import diuf.unifr.ch.rest.test1.jaxb.AbstractComponent;
import diuf.unifr.ch.rest.test1.jaxb.Led;
import diuf.unifr.ch.rest.test1.resources.LedResource;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leo
 */
public class SimpleLed extends ArduinoCommunication {
    
    private static final Logger logger = LoggerFactory.getLogger(SimpleLed.class);

    @Override
    public void setComponent(Object o) {
        o = (Led) o;
        write(o);
    }

    @Override
    public Led getComponent() {
        logger.error(getConnection().getLine());
        return null;
    }
    
}
