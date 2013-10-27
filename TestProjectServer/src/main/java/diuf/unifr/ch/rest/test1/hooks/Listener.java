/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diuf.unifr.ch.rest.test1.hooks;

import com.sun.jersey.api.model.AbstractResourceModelContext;
import com.sun.jersey.api.model.AbstractResourceModelListener;
import diuf.unifr.ch.rest.test1.resources.MyResource;
import javax.ws.rs.ext.Provider;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leo
 */
@Provider
public class Listener implements AbstractResourceModelListener{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyResource.class);
    
    @Override
    public void onLoaded(AbstractResourceModelContext armc) {
        logger.info("RXTX class loaded");
    }
    
}
