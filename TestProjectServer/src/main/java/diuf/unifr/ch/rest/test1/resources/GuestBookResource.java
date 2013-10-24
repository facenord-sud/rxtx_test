package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.persistence.GuestBooksEntity;
import diuf.unifr.ch.rest.test1.resources.exceptions.NotFoundException;
import diuf.unifr.ch.rest.test1.utils.JPAUtils;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author leo
 */
@Path("/guest-book/{id}")
public class GuestBookResource {

    private JPAUtils jp = new JPAUtils();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getGuestBook(@PathParam("id") int id) {
        GuestBooksEntity gb = findGuestBookEntity(id);
        return Response.ok(gb).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response updateGusetBookEntityXml(@PathParam("id") int id, GuestBooksEntity gbModified) {
        GuestBooksEntity gb = findGuestBookEntity(id);
        gb.setName(gbModified.getName());
        if (jp.mergeEntity(gb) == null) {
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.ok(gb).build();

    }

    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    public Response delGuestBookEntityXml(@PathParam("id") int id) {
        GuestBooksEntity gb = findGuestBookEntity(id);
        if (jp.removeEntity(gb) == null) {
            return Response.notModified().build();
        }
        return Response.ok(gb).build();
    }

    private GuestBooksEntity findGuestBookEntity(int id) {
        try {
            GuestBooksEntity gb = (GuestBooksEntity) jp.getEm().
                    createNamedQuery("GuestBook.find").
                    setParameter("id", id).
                    getSingleResult();
            return gb;
        } catch (javax.persistence.NoResultException e) {
            throw new NotFoundException();
        }
    }
}
