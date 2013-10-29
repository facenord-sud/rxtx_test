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

/**
 *
 * @author leo
 */
public abstract class ArduinoCommunication {

    private RxtxConnection connection;
    private String json;
    private Gson gson;

    public ArduinoCommunication() {
        gson = new Gson();
        try {
            connection = RxtxConnection.getInstance();
            addNewDataListener();
        } catch (PortInUseException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCommOperationException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TooManyListenersException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addNewDataListener() throws TooManyListenersException {
        connection.getSerialPort().addEventListener(new SerialPortEventListener() {

                @Override
                public void serialEvent(SerialPortEvent spEvent) {
                    if (spEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                        try {
                            String line = connection.getInput().readLine();
                            if (!line.equals("")) {
                                json = line;
                            }
                        } catch (IOException e) {
                            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, "IO exception. Are you closing ?", e);
                        }
                    }
                }
            });
            connection.getSerialPort().notifyOnDataAvailable(true);
    }
    
    public void write(Object o) {
        try {
            connection.getOutput().writeChars(gson.toJson(o));
        } catch (IOException ex) {
            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract void setComponent(Object o);

    public abstract <T> T getComponent();

    public String getJson() {
        return json;
    }
    
}
