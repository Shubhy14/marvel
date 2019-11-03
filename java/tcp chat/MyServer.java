import java.io.*;
import java.net.*;
import java.util.Scanner;
public class MyServer
{
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	Scanner sc=new Scanner(System.in);
	public MyServer()
	{
		String msg,rep;
		try
		{
			ss=new ServerSocket(1969);
			s=ss.accept();
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				msg=dis.readUTF();
				System.out.println("Client Says : "+msg);
				System.out.println("Enter Message : ");
				rep=sc.nextLine();
				dos.writeUTF(rep);
				if(rep.equalsIgnoreCase("stop"))
				{
					dos.flush();
					dos.close();
					dis.close();
					s.close();
					ss.close();
				}
			}
		}
		catch(Exception e) {}
	}
	public static void main(String[] args)
	{
		new MyServer();
	}
}
