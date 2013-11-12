package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.jaxb.ContiniousServo;
import diuf.unifr.ch.rest.test1.rxtx.TinkerShield;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import diuf.unifr.ch.rest.test1.rxtx.utils.RxtxUtils;

/**
 *
 * @author leo
 */
@Path("servo")
public class ServoResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getServoResource() {
        return Response.ok(new RxtxUtils().getComponent(ContiniousServo.class, TinkerShield.o_0)).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response setServoResource(ContiniousServo servo) {
        servo.setPin(TinkerShield.o_0);
        new RxtxUtils().setComponent(servo);
        return Response.ok(servo).build();
    }

}
