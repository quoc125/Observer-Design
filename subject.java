/*
Quoc Le
COP 3503-0001
Observer Design
14 April 2016
*/
public interface subject {
	public void create(account a);
	public void delete(account a);
	public void notifyAccount();

}
