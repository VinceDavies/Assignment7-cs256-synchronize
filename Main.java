package assignment7b;

public class Main {
	
	public static void main (String[] args){
		Object obj1 = new Object();
		CompSyncRunnable compSync1= new CompSyncRunnable ("hi",10,"CompSync.txt",obj1);
		CompSyncRunnable compSync2= new CompSyncRunnable ("bye",10,"CompSync.txt",obj1);
		Thread t1=new Thread(compSync1);
		Thread t2=new Thread(compSync2);
		t1.start();
		t2.start();
	}

}
