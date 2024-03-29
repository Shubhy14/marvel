import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.StringTokenizer; 
  
public class UDPServer 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1234); 
        byte[] buf = null; 
        DatagramPacket DpReceive = null; 
        DatagramPacket DpSend = null; 
        while (true) 
        { 
            buf = new byte[65535]; 
            // create a DatgramPacket to receive the data. 
            DpReceive = new DatagramPacket(buf, buf.length); 
            // receive the data in byte buffer. 
            ds.receive(DpReceive); 
            String inp = new String(buf, 0, buf.length); 
            //To remove extra spaces. 
            inp=inp.trim(); 
            System.out.println("Equation Received:- " + inp); 
            // Exit the server if the client sends "bye" 
            if (inp.equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
            float result; 
            // Use StringTokenizer to break the 
            // equation into operand and operation 
            StringTokenizer st = new StringTokenizer(inp); 
            float oprnd1 = Float.parseFloat(st.nextToken()); 
            String operation = st.nextToken(); 
            float oprnd2 = Float.parseFloat(st.nextToken()); 
            // perform the required operation. 
            if (operation.equals("+")) 
                result = oprnd1 + oprnd2; 
            else if (operation.equals("-")) 
                result = oprnd1 - oprnd2; 
            else if (operation.equals("*")) 
                result = oprnd1 * oprnd2; 
            else
                result = oprnd1 / oprnd2; 
            System.out.println("Sending the result..."); 
            String res = Float.toString(result); 
            // Clear the buffer after every message. 
            buf = res.getBytes(); 
            // get the port of client. 
            int port = DpReceive.getPort(); 
            DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port); 
            ds.send(DpSend); 
        } 
    } 
}
