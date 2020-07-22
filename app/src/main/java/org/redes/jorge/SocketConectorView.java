package org.redes.jorge;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.redes.jorge.Messages;
/**
 *
 * @author alsorc
 */
public class SocketConectorView {

    private static SocketConectorView mySocket = null;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private SocketConectorView() throws IOException {
        
        //IP de mi servidor
        InetAddress ip = InetAddress.getByName("192.168.0.108");

        // establish the connection with server port 5056 
        this.socket = new Socket(ip, 5056);
        
        // obtaining input and out streams 
        this.dis = new DataInputStream(this.socket.getInputStream());
        this.dos = new DataOutputStream(this.socket.getOutputStream());
    }

    public static SocketConectorView getSocketConector() throws IOException {
        if (mySocket == null) {
            mySocket = new SocketConectorView();
        }
        return mySocket;
    }
    
    
    public void sendMessage(Messages msg) throws IOException{
        this.dos.writeUTF(msg.getValue());
    }
    
    public DataInputStream getInputData(){
        return this.dis;
    }



}
