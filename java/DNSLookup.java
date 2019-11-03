import java.net.*;
import java.util.Scanner;
public class DNSLookup
{
	public void getIPfromURL(String str)
	{
		try
		{
			InetAddress in=InetAddress.getByName(new URL(str).getHost());
			System.out.println("IP : "+in.getHostAddress());
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void getHostnamefromIP(String str)
	{
		try
		{
			InetAddress inet=InetAddress.getByName(str);
			String hostname=inet.getHostName();
			String canonicalHostname=inet.getCanonicalHostName();
			System.out.println("Hostname : "+hostname);
			System.out.println("Canonical Hostname : "+canonicalHostname);
		}
		catch(Exception e){System.out.println(e.getMessage());}	}
	public static void main(String[] args)
	{
		int ch;
		String str;
		Scanner s=new Scanner(System.in);
		DNSLookup obj=new DNSLookup();
		do
		{
			System.out.println("1. IP Address from URL\n2. Hostname from IP Address\n3. Exit\nEnter Your Choice : ");
			ch=Integer.parseInt(s.nextLine());
			switch(ch)
			{
				case 1:
					System.out.println("Enter URL : ");
					str=s.nextLine();
					obj.getIPfromURL(str);
					break;
				case 2:
					System.out.println("Enter IP Address : ");
					str=s.nextLine();
					obj.getHostnamefromIP(str);
					break;
			}
		}
		while(ch!=3);
	}
}
