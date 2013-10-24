/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.persistence.UsersEntity;
import diuf.unifr.ch.rest.test1.resources.exceptions.NoContentException;
import diuf.unifr.ch.rest.test1.utils.JPAUtils;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author leo
 */

@Path("/users")
public class UsersResource {
    
    private JPAUtils jp = new JPAUtils();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<UsersEntity> getUserListXml() {
        List <UsersEntity> users = (List <UsersEntity>) jp.getEm().createNamedQuery("UsersEntity.findAll").getResultList();
        if(users.isEmpty()) {
            throw new NoContentException();
        }
        return users;
    }
}
