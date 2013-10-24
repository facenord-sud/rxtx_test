/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.resources;

import diuf.unifr.ch.rest.test1.persistence.UsersEntity;
import diuf.unifr.ch.rest.test1.resources.exceptions.NotFoundException;
import diuf.unifr.ch.rest.test1.utils.JPAUtils;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
@Path("/user/{name}")
public class UserResource {

    private JPAUtils jp = new JPAUtils();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getUserXml(@PathParam("name") String name) {
        UsersEntity u = findUserEntity(name);
        return Response.ok(u).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response setUserXml(@PathParam("name") String name, UsersEntity user) {
        try {
            UsersEntity userToUpdate = (UsersEntity) jp.getEm().
                    createNamedQuery("UsersEntity.findByName").
                    setParameter("name", name).
                    getSingleResult();
            userToUpdate.setEmail(user.getEmail());
            return Response.status(Response.Status.OK).entity(jp.mergeEntity(userToUpdate)).build();
        } catch (NoResultException e) {
            user.setName(name);
            jp.persistEntity(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
        }

    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    public Response delUserXml(@PathParam("name") String name) {
        return Response.ok(jp.removeEntity(findUserEntity(name))).build();
    }

    private UsersEntity findUserEntity(String name) {
        try {
            UsersEntity user = (UsersEntity) jp.getEm().
                    createNamedQuery("UsersEntity.findByName").
                    setParameter("name", name).
                    getSingleResult();
            return user;
        } catch (javax.persistence.NoResultException e) {
            throw new NotFoundException();
        }
    }
}
