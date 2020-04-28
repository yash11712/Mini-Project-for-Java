import java.util.*;

class train_details
{
	int tno;
	String tname;
	String bp,dp;
	
	int fc,fcfare;
	int sc,scfare;
	int d,m,y;
	void getdata()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the train number");
		tno=s.nextInt();
		System.out.println("Enter the train name");
		tname=s.next();
		System.out.println("Enter the boarding point and destination point");
		bp=s.next();
		dp=s.next();
		System.out.println("Enter the first class seats and fare");
		fc=s.nextInt();
		fcfare=s.nextInt();
		System.out.println("Enter the second class seats and fare");
		sc=s.nextInt();
		scfare=s.nextInt();
		System.out.println("enter the date,month,year of departure");
		d=s.nextInt();
		m=s.nextInt();
		y=s.nextInt();
	}
	void dispdata()
	{
		System.out.println(tno+" "+tname+" "+bp+" "+dp+" "+fc+" "+fcfare+" "+sc+" "+scfare+" "+d+"-"+m+"-"+y);
	}

}

class user_details
{
	String Name;
	String username;
	int Password;
	String Address;
	long Mobile_No;
	
	public user_details()
	{
		Password=0000;
		Mobile_No=0;
	}
	
	public void getDetails()
	{
		
		int Digits=0;
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Name ...");
		Name=scan.next();
		
		System.out.println("Enter Full Address ...");
		Address=scan.next();
		
		do
			{
			System.out.println("Enter Valid Mobile Number(10 digits)");
			Mobile_No=scan.nextLong();
			Digits=String.valueOf(Mobile_No).length();
			}while(Digits-1==10);
		
			System.out.println("Enter Proper User name");
			username=scan.next();
		
		do {
		System.out.println("Enter valid password(4 digits)");
		Password=scan.nextInt();
		Digits=String.valueOf(Password).length();
		}while(Digits!=4);
	}
	
	public void display_user()
	{
		System.out.println("User Details:\n Name: "+Name+"\n Address:"+Address+"\n Username:"+username+"\n Password:"+Password+"\n Mobile Number:"+Mobile_No);
	}
}

