import java.util.*;
public class Main {

	public static void main(String[] args) 
	{
		int CHOICE;
		
		Scanner scan=new Scanner(System.in);
		int choice;
		int userIndex;
		int Rdate,Rmonth,Ryear;
		
		Reserve Data[]=new Reserve[50];
		int Reservation_cnt=0,tickets=0;
		Login L;
		System.out.println("Welcome to User Mode!");
		
		train_details train[]=new train_details[50];
		user_details users[]=new user_details[50];
		int members=0,train_no=0;
		int choice1,choice2;
		int cost=0,refund=0;
		System.out.println("Enter Your Choice!");
		System.out.println("1.Administrator Mode\n2.User Mode\n3.Quit\n");
		CHOICE=scan.nextInt();
		do {
		switch(CHOICE)
		{
		case 1:
			System.out.println("Welcome to Admin Mode");
			do
			{	
				System.out.println("Enter your choice:-");
				System.out.println("1.Create Database\n2.Add details\n3.Display details\n4.User management\n5.Quit\n");
				choice1=scan.nextInt();
				switch(choice1)
				{
					case 1:
						System.out.println("Enter no of train entries you want to add");
						int n=scan.nextInt();
						for(int i=0;i<n;i++)
						{
							train[train_no]=new train_details();
							train[train_no].getdata();
							train_no++;
						}
						break;
					case 2:
						train[train_no]=new train_details();
						train[train_no].getdata();
						train_no++;
						break;
					case 3:
						for(int i=0;i<train_no;i++)
						{
							train[i].dispdata();
						}
					break;
					case 4:
						
						do
						{
							System.out.println("Enter your choice:-");
							System.out.println("1.Create Id\n2.display details\n3.quit");
							choice2=scan.nextInt();
							switch(choice2)
							{
							case 1:
								users[members]=new user_details();
								users[members].getDetails();
								members++;
								break;
							case 2:
								for(int i=0;i<members;i++)
								{
									users[i].display_user();
								}
								break;
							}
						}while(choice2!=3);
					break;
					
				}
			}while(choice1 != 5);	
			
			break;
		case 2:
			
			L=new Login();
			System.out.println("Welcome to User Mode!");
			userIndex=L.doLogin(users,members);

			do
			{	
				System.out.println("Enter your choice:-");
				System.out.println("1.Show Train Data\n2.Reserve Ticket\n3.Cancel Ticket\n4.Display My Reservations\n5.Quit");
				choice=scan.nextInt();
				switch(choice)
				{
				case 1:
					for(int i=0;i<train_no;i++)
					{
						train[i].dispdata();
					}
					break;
				case 2:
					int test=0;
					int journey_train;
					System.out.println("Enter the following details- ");
					do
					{
						System.out.println("Enter train number");
						journey_train=scan.nextInt();
						for(int i=0;i<train_no;i++)
						{
							if(journey_train==train[i].tno)
							{
								test=1;
							}
						}
						if(test==0)
							System.out.println("Enter valid train number");
					}while(test==0);
					System.out.println("Enter Date,Month and Year for journey(dd,mm,yyyy)\t");
					Rdate=scan.nextInt();
					Rmonth=scan.nextInt();
					Ryear=scan.nextInt();
					System.out.print("Enter total tickets to be reserved\t");
					tickets=scan.nextInt();
					
					for(int i=0;i<tickets;i++)
					{
						Data[Reservation_cnt]=new Reserve(Rdate,Rmonth,Ryear,journey_train);
						Data[Reservation_cnt].doReserve();
						Reservation_cnt++;
					}
					System.out.println("All tickets Reserved!");
					break;
				case 3:
					
					System.out.println("Enter date ,month and year of the journey ");
					Rdate=scan.nextInt();
					Rmonth=scan.nextInt();
					Ryear=scan.nextInt();
					Data[0].doCancel(Data,tickets,Rdate,Rmonth,Ryear);
					System.out.println("Tickets cancelled");
					break;
				case 4:
					for(int i=0;i<tickets;i++)
					{
						Data[i].display_tickets();
					}
				}
			}while(choice != 5);
			break;
			
		}
		}while(CHOICE!=3);
			
	}
		
}


