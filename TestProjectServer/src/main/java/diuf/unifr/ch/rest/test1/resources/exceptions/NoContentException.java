/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.resources.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author leo
 */
public class NoContentException extends WebApplicationException{
    
    public NoContentException() {
        this("This resource have no records");
    }
    
    public NoContentException(String _message)
    {
        super(Response.status(Response.Status.NO_CONTENT).entity(_message).build());
    }
    
}
