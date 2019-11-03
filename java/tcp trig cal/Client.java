import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	Scanner sc=new Scanner(System.in);
	public Client()
	{
		try
		{
			s=new Socket("localhost",4321);
			dis=new DataInputStream(s.getInputStream());
			dos=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				System.out.println("1. Sin\n2. Cos\n3. Tan\n4. Cot\n5. Sec\n6. Cosec\n7. Exit\nEnter Your Choice : ");
				int ch=sc.nextInt();
				if(ch==7)
				{
					dos.writeInt(ch);
					System.exit(0);
				}
				System.out.println("Enter Angle in Degree : ");
				double ang=sc.nextDouble();
				double ang1=Math.toRadians(ang);
				dos.writeInt(ch);
				dos.writeDouble(ang1);
				double ans=dis.readDouble();
				System.out.println("Answer Is : "+ans);
			}
		}
		catch(ArithmeticException e){System.out.println("Infinity Value...");}
		catch(Exception e) {}
	}
	public static void main(String[] args)
	{
		new Client();
	}
}
