package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.jaxb.TouchSensor;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import diuf.unifr.ch.rest.test1.rxtx.utils.RxtxUtils;

/**
 *
 * @author leo
 */

@Path("/touch-button")
public class TouchButtonResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getTouchButtonResource() {
        return Response.ok(new RxtxUtils().getComponent(TouchSensor.class, TinkerShield.i_0)).build();
    }

}
