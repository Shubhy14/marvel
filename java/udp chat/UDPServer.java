import java.io.*;
import java.net.*;
public class UDPServer
{
	public static DatagramSocket ss;
	public static DatagramPacket dp;
	public static BufferedReader dis;
	public static InetAddress ia;
	public static byte buf[]=new byte[1024];
	public static int cport=789,sport=790;
	public static void main(String[] args) throws Exception
	{
		ss=new DatagramSocket(sport);
		dp=new DatagramPacket(buf,buf.length);
		dis=new BufferedReader(new InputStreamReader(System.in));
		ia=InetAddress.getLocalHost();
		System.out.println("Server is running...");
		while(true)
		{
			ss.receive(dp);
			String str=new String(dp.getData(),0,dp.getLength());
			if(str.equalsIgnoreCase("STOP"))
			{
				System.out.println("Terminated...");
				break;
			}
			System.out.println("Client : "+str);
			String str1=new String(dis.readLine());
			buf=str1.getBytes();
			ss.send(new DatagramPacket(buf,str1.length(),ia,cport));
		}
	}
}
