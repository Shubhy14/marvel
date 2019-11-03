import java.io.*;
import java.net.*;
import java.util.Scanner;
public class MyClient
{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	Scanner sc=new Scanner(System.in);
	public MyClient()
	{
		String msg,rep;
		try
		{
			s=new Socket("localhost",1969);
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				System.out.println("Enter Message : ");
				msg=sc.nextLine();
				dos.writeUTF(msg);
				rep=dis.readUTF();
				if(msg.equalsIgnoreCase("stop"))
				{
					dos.flush();
					dos.close();
					dis.close();
					s.close();
				}
				System.out.println("Server Says : "+rep);
			}
		}
		catch(Exception e) {}
	}
	public static void main(String[] args)
	{
		new MyClient();
	}
}
