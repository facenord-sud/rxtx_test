/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import diuf.unifr.ch.rest.test1.utils.JPAUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:andreas.ruppen@gmail.com">Andreas Ruppen</a>
 */
@Path("/caregivers/{cid}")
public class MyResource {

    @Context
    protected UriInfo uriInfo;
    @Context
    SecurityContext security;
    @Context
    protected JPAUtils jpautils;
    @PathParam("cid")
    Integer cid;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyResource.class);
    

    /*
    @GET
    @Produces({"application/xml", "application/json", "text/xml"})
    public Caregiver getCaregiverXML() {
        return getCaregiver(JPAUtils.getCaregiverEntity(cid, em));
    }

    @GET
    @Produces("text/html")
    public Response getCareGiverHTML() {
        // Null Value handled by JSP File.
        Caregiver _car = getCaregiverXML();
        Response.ResponseBuilder rB = new ResponseBuilderImpl();
        rB.entity(new Viewable("/WEB-INF/view/caregiver.jsp", _car));
        return rB.build();
    }

    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Produces({"application/xml", "application/json", "text/xml"})
    public Caregiver setCaregiverURL(@FormParam("firstName") String _firstName,
            @FormParam("lastName") String _lastName,
            @FormParam("speciality") String _speciality,
            @FormParam("monthsOfExperience") String _monthsOfExperience,
            @FormParam("street") String _street,
            @FormParam("streetNumber") String _streetNumber,
            @FormParam("city") String _city,
            @FormParam("zip") String _zip) {
        //TODO only a caregiver should be able to modify its profile.
        //First Check if null parameters in request
        int monthsOfExperience = (_monthsOfExperience != null) ? Integer.parseInt(_monthsOfExperience) : 0;
        int streetNumber = (_streetNumber != null) ? Integer.parseInt(_streetNumber) : 0;
        int zip = (_zip != null) ? Integer.parseInt(_zip) : 0;
        return null;
    }

    @DELETE
    @Produces("text/plain")
    public Response delCaregiver() {
        Response.ResponseBuilder rb = new ResponseBuilderImpl();
        rb.entity("Successfully deleted Caregiver with CID: " + cid);
        rb.status(Response.Status.OK);
        return rb.build();
    }

    @DELETE
    @Produces({"application/xml", "application/json", "text/xml"})
    public Response delCaregiverXML() {
        if (security.getUserPrincipal() == null) {
            throw new ForbiddenException();
        } else if (!security.isUserInRole("caregiver")) {
            throw new UnauthorizedException();
        }
        Response.ResponseBuilder rb = new ResponseBuilderImpl();
        Caregiver cg = getCaregiver(JPAUtils.getCaregiverEntity(cid, em));
        if (cg != null) {
            rb.entity(cg);
            removeCaregiver(JPAUtils.getCaregiverEntity(cid, em));
            rb.status(Response.Status.OK);
        } else {
            throw new NotFoundException("This caregiver does not exist");
        }
        return rb.build();
    }
    */
}
