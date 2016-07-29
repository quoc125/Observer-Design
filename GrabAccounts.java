/*
Quoc Le
COP 3503-0001
Observer Design
14 April 2016
*/
import java.util.Scanner;

public class GrabAccounts {
	public static void main(String[] args)
	{
		data Data = new data();

		int input =0;
		Scanner scanner = new Scanner(System.in);
		while (input != 5)
		{
			System.out.println("1: Create new account");
			System.out.println("2: Toggle SleepMode on an account");
			System.out.println("3. Edit Youtube Account Info.");
			System.out.println("4. Delete Account");
			System.out.println("5. Exit");
			input = scanner.nextInt();
			if (input <=5 && input > 0)
			{
				int account;
				if (input ==1 ) //Create a new observer
					new YoutubeStat(Data);
				else if (input == 2) //Set an account to go to sleep
				{
					System.out.println("Which account do you want to go to sleep");
					account = scanner.nextInt();
					//find the account
					account temp = Data.findAccount(account);
					//set that account to sleep
					temp.toogleSleep();
				}
				else if (input == 3)
				{
					//Allow the user to change stat, multiple time
					System.out.println("How may stat do you want to edit");
					int count = scanner.nextInt();
					for(int i = 0; i < count; i++)
					{
						System.out.println("Which stat do you want to edit");
						System.out.println("1. Subscriber Count");
						System.out.println("2. Video Count");
						System.out.println("3. Viewer Count");
						int determine =scanner.nextInt();
						System.out.println("What do you want the new value to be ");
						int newValue = scanner.nextInt();
						if (determine == 1)
						{
							Data.setSubCount(newValue);
						}
						else if (determine ==2)
						{
							Data.setVideoCount(newValue);
						}
						else if (determine == 3)
							Data.setViewCount(newValue);
						
						else //if it's not a valid input, reduce the count
							count--;
					}
					
				}
				else if (input == 4)
				{
					System.out.println("Which account do you want to delete");
					account = scanner.nextInt();
					account temp = Data.findAccount(account);
					Data.delete(temp);
				}
				else 
					System.out.println("Exit");
					
			}
			else 
			System.out.println("Enter a valid input");
			try { //Slow down the responce, in order to allow the user to see
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}
