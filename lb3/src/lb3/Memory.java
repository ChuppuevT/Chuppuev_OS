package lb3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Memory {
	private TablePages virtualMemory;
	private Queue<Page> pageQueue;
	private int frame;
	Random randomBits = new Random ();
	
	public Memory(int RAM, int sizePage) {
		virtualMemory = new TablePages();
		pageQueue = new PriorityQueue<Page>();
		frame = RAM / sizePage;
		for (int i = 0; i < RAM*2; i++) {
			Page page = new Page(randomBits.nextInt()+1, false, i);
			virtualMemory.add(page);
		}
	}
	
	public void insert(int pageIndex) {
		Object[] resultObjects;
    	SecondAlgoritm algorithm = new SecondAlgoritm (virtualMemory, pageQueue);
    	Page page = virtualMemory.Get(pageIndex);
    	 if(!page.getAvailability()){
    		 if(pageQueue.size() < frame){
    			 page.setAvailability(true);
    			 pageQueue.add(page);
    		 }
    		 else if(pageQueue.size() == frame) {
    			 resultObjects = algorithm.SecondChance(page);
    			 pageQueue = (Queue<Page>) resultObjects[0];
                 virtualMemory.setPagesRecords((LinkedList<Page>) resultObjects[1]);
    		 }
    	 }
	}
	public int getVirtualMemorySize(){
        return virtualMemory.Size();
    }
}
