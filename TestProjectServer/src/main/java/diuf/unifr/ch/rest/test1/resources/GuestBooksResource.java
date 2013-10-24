package diuf.unifr.ch.rest.test1.resources;


import diuf.unifr.ch.rest.test1.persistence.GuestBooksEntity;
import diuf.unifr.ch.rest.test1.resources.exceptions.NoContentException;
import diuf.unifr.ch.rest.test1.utils.JPAUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
@Path("/guest-books")

public class GuestBooksResource {
   
    private JPAUtils jp = new JPAUtils();
   
    @Produces(MediaType.APPLICATION_XML)
    @GET
   public List<GuestBooksEntity> getGuestbooksXml() {
       List<GuestBooksEntity> results = jp.getEm().createNamedQuery("GuestBook.all").getResultList();
       if(results.isEmpty()) {
           throw new NoContentException();
       }
       return results;
   }
    
   @Produces(MediaType.APPLICATION_XML)
   @DELETE
   public List<GuestBooksEntity> delGuestBooks() {
       List<GuestBooksEntity> results = jp.getEm().createNamedQuery("GuestBook.all").getResultList();
       if(results.isEmpty()) {
           throw new NoContentException();
       }
       for(GuestBooksEntity aGuestBook : results) {
           jp.removeEntity(aGuestBook);
       }
       return results;
   }
   
   @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response setGuestBookXml(GuestBooksEntity gb) {
       GuestBooksEntity gbPersisted = jp.persistEntity(gb);
        if(gbPersisted != null) {
            return Response.ok(gbPersisted).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }
}
