

package assignment7b;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CompSyncRunnable implements Runnable {
	private String message;
	private int count;
	private String fileName;
	private Object object;
	
	public CompSyncRunnable (String msg, int cnt, String fname, Object obj) {
		message=msg;
		count=cnt;
		fileName=fname;
		object = obj;
	}
	
	@Override
	public void run(){
		PrintWriter pw =null;
		try{
		
		pw= new PrintWriter (new FileWriter (fileName, true), true);
		} catch(IOException e){
			e.printStackTrace();
			
			try {
				Thread.sleep (100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		for (int i=0; i<count; i++) {
			synchronized (object) {
		        //A single write within the loop will be here
		        pw.println (message);
		        
		      
		        try {
					Thread.sleep (100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		        
		        
		}
		try {
			Thread.sleep (100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		}
	}


