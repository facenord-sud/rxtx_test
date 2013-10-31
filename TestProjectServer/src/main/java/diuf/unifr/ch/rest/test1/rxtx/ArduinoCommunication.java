/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diuf.unifr.ch.rest.test1.rxtx;

import com.google.gson.Gson;
import gnu.io.PortInUseException;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leo
 */
public abstract class ArduinoCommunication {

    private RxtxConnection connection;
    private final Gson gson;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ArduinoCommunication.class);

    public ArduinoCommunication() {
        gson = new Gson();
        try {
            connection = RxtxConnection.getInstance();
        } catch (PortInUseException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCommOperationException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException e) {
            logger.error("null instance of rxtxConnection");
        }
    }
    
    
    
    public void write(Object o) {
        try {
            connection.getOutput().write(gson.toJson(o).getBytes());
            logger.debug("writing to arduino : "+ gson.toJson(o));
        } catch (IOException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract void setComponent(Object o);

    public abstract <T> T getComponent();

    public RxtxConnection getConnection() {
        return connection;
    }

    public void setConnection(RxtxConnection connection) {
        this.connection = connection;
    }

    public Gson getGson() {
        return gson;
    }
    
    
}
