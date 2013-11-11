/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.resources;


import diuf.unifr.ch.rest.test1.jaxb.Led;
import diuf.unifr.ch.rest.test1.rxtx.ArduinoCommunication;
import diuf.unifr.ch.rest.test1.rxtx.RxtxConnection;
import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import diuf.unifr.ch.rest.test1.rxtx.utils.RxtxUtils;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leo
 */
@Path("/led")
public class LedResource {
    
    private static final Logger logger = LoggerFactory.getLogger(LedResource.class);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getLed() {
        logger.debug("get");
        Led l = new RxtxUtils().getComponent(Led.class, TinkerShield.i_0);
        return Response.ok(l).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response setLed(Led led) {
        logger.debug("put");
        led.setPin(TinkerShield.i_0.toInt());
        new RxtxUtils().setComponent(led);
        return Response.ok(led).build();
    }
}
