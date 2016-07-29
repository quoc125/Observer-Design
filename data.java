/*
Quoc Le
COP 3503-0001
Observer Design
14 April 2016
*/
import java.util.ArrayList;

public class data implements subject{
	
	private ArrayList<account> accounts;
	private int videoCount;
	private int subCount;
	private int viewCount;
	private int numDel = 0; // to avoid stack overflow, while keeping the same index
	public data()//make new account
	{
		accounts = new ArrayList<account>();
	}
	@Override
	public void create(account newAccount) {//add new account to list
		// TODO Auto-generated method stub
		accounts.add(newAccount);
	}

	@Override
	public void delete(account delAccount) { //delete account from list
		// TODO Auto-generated method stub
		int accountIndex = accounts.indexOf(delAccount);
		System.out.println("Account " + (accountIndex+1) + " deleted");
		numDel++;
		accounts.remove(accountIndex);
	}

	@Override
	public void notifyAccount() { // Notify each account in list
		// TODO Auto-generated method stub
		for( account viewer :  accounts)
		{
			viewer.update(videoCount, subCount, viewCount);
			try {
				Thread.sleep(100); // slow down the print of each observer 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//set new video count
	public void setVideoCount( int videoCount)
	{
		this.videoCount = videoCount;
		notifyAccount();
	}
	//set new sub count
	public void setSubCount(int subCount)
	{
		this.subCount = subCount;
		notifyAccount();
	}
	//set new view count
	public void setViewCount(int viewCount)
	{
		this.viewCount = viewCount;
		notifyAccount();

	}
	//find the accounts with the corresponding id
	public account findAccount(int index)
	{
		
		return accounts.get(index-1 -numDel);
	}

}
