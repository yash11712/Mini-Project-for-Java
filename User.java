import java.util.*;
class Reserve
{
	int Train_No;
	String Passanger_name;
	int Age;
	int Birth_Class;
	int date,month,year;
	int del_key;
	public Reserve(int d,int m,int y,int train_pno)
	{
		Age=0;
		Birth_Class=0;
		date=d;
		month=m;
		year=y;
		del_key=0;
		Train_No=train_pno;
	}
	
	public void doReserve()
	{
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter Passanger name:\t");
			Passanger_name=scan.next();
			System.out.print("Enter age:\t");
			Age=scan.nextInt();
			System.out.print("Enter Birth Class\n1.First 2.Second\t");
			Birth_Class=scan.nextInt();
			
			
	}
	
		
	public void doCancel(Reserve R[],int n,int d,int m,int y)
	{
		Scanner scan=new Scanner(System.in);
		int no_deleted,cnt=0;
		for(int i=0;i<n;i++)
		{
			System.out.println("Tickets reserved for this day are :");
			if(R[i].date==d && R[i].month==m && R[i].year==y)
			{
				R[i].display_tickets();
				cnt++;
			}
		}
			do
			{
				System.out.println("Enter no of tickets to be deleted");
				no_deleted=scan.nextInt();
				if(no_deleted>cnt)
				{
					System.out.println("Enter valid number of tickets");
				}
			}while(no_deleted>cnt);
			
			String P_name;
			for(int j=0;j<no_deleted;j++)
			{
				System.out.println("Enter Passanger Name for ticket deletion");
				P_name=scan.next();
				for(int k=0;k<n;k++)
				{
					if(R[k].Passanger_name.equalsIgnoreCase(P_name))
					{
						R[k].del_key=1;
					}
				}
			}
	}
	
	public void display_tickets()
	{
		if(del_key==0)
		{
			System.out.print("Passanger Name: "+Passanger_name+"\nAge: "+Age+"\nBirth Class");
			if(Birth_Class==1)
			{
				System.out.print("First");
			}
			else
				System.out.print("Second");
			
			System.out.println("\nDate :"+date+"/"+month+"/"+year);
		}
		
	}
}
class Login
{
	String user_name;
	int pass_word;
	
	public int doLogin(user_details u[],int n)
	{
		int check=-1;
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.println("Enter the valid username");
			user_name=scan.next();
			for(int i=0;i<n;i++)
			{
				if(user_name.equalsIgnoreCase(u[i].username))
				check=i;
				else
					System.out.println("Username Invalid!");
			}
		}while(check==-1);
		do
		{
			System.out.println("Enter the valid password");
			pass_word=scan.nextInt();
			if(pass_word==u[check].Password)
				break;
			else
				System.out.println("Password Invalid!");
		}while(check!=-1);
		System.out.println("Login Succeed!!");
		return check;
	}
}


