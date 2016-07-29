/*
Quoc Le
COP 3503-0001
Observer Design
14 April 2016
*/
public class YoutubeStat implements account{
	private int videoCount;
	private int subCount;
	private int viewCount;
	private static int accountIDTracker = 0;
	private int accountID;
	private boolean sleep;
	private subject Subject;
	//create an id for each observer
	public YoutubeStat(subject Subject)
	{
		this.Subject = Subject;
		sleep = false;
		this.accountID = ++accountIDTracker;
		System.out.println("New Account " + this.accountID);
		Subject.create(this);
	}
	@Override
	//update each value
	public void update(int videoCount, int subCount, int viewerCount) {
		this.videoCount = videoCount;
		this.subCount = subCount;
		this.viewCount = viewerCount;
		if (!sleep)
			printTheData();
	}
	public void printTheData()
	{
		System.out.println(accountID);
		System.out.println("The video count is " + videoCount);
		System.out.println("The sub count is " + subCount);
		System.out.println("The view count is "+ viewCount);
	}
	@Override
	//Toggle sleep
	public void toogleSleep() {
		// TODO Auto-generated method stub
		sleep = !sleep;
	}
	
}
