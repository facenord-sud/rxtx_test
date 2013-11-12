package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.jaxb.Thermistor;
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

@Path("/temp")
public class ThermistorResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getThermistorResource() {
        Thermistor t = new RxtxUtils().getComponent(Thermistor.class, TinkerShield.i_1);
        return Response.ok(t).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response setThermistorResource(Thermistor thermistor) {
        thermistor.setPin(TinkerShield.i_1);
        new RxtxUtils().setComponent(thermistor);
        return Response.ok().build();
    }

}
