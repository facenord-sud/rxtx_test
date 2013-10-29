package diuf.unifr.ch.rest.test1.rxtx;

import diuf.unifr.ch.rest.test1.resources.MyResource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 * The most part of this code is exactly the same as in this web page:
 * http://playground.arduino.cc/Interfacing/Java A lit bit of apaptation
 *
 * @author leo and uknow author (http://playground.arduino.cc/Interfacing/Java)
 */
public class RxtxConnection {

    private static SerialPort serialPort;

    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbmodem1421", // Mac OS X
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };

    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     * from arduino website
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    private static RxtxConnection instance = null;
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RxtxConnection.class);
    
    private String line;

    private RxtxConnection() throws PortInUseException, UnsupportedCommOperationException, IOException {
        initialize();
    }

    public static RxtxConnection getInstance() throws PortInUseException, UnsupportedCommOperationException, IOException {
        if (instance == null) {
            instance = new RxtxConnection();
            logger.trace("Connection initialized");
        }
        return instance;
    }

    private void initialize() throws PortInUseException, UnsupportedCommOperationException, IOException {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            close();
            System.exit(0);
        }

            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();
        try {
            addNewDataListener();
        } catch (TooManyListenersException ex) {
            Logger.getLogger(RxtxConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void addNewDataListener() throws TooManyListenersException {
        serialPort.addEventListener(new SerialPortEventListener() {

                @Override
                public void serialEvent(SerialPortEvent spEvent) {
                    if (spEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                        try {
                            String _line = input.readLine();
                            if (!_line.equals("")) {
                                line = _line;
                            }
                            logger.error("ça modifie"+_line);
                        } catch (IOException e) {
                            Logger.getLogger(ArduinoCommunication.class.getName()).log(Level.SEVERE, "IO exception. Are you closing ?", e);
                        }
                    }
                }
            });
            serialPort.notifyOnDataAvailable(true);
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public static synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public BufferedReader getInput() {
        return input;
    }

    public OutputStream getOutput() {
        return output;
    }

    public String getLine() {
        return line;
    }

}
