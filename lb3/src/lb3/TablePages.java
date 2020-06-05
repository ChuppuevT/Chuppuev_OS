package lb3;

import java.util.LinkedList;

public class TablePages {
	private LinkedList<Page> pagesRecords;
	
	public TablePages() {
		pagesRecords = new LinkedList<Page>();
	}
	
	public LinkedList<Page> getPagesRecords(){
		return pagesRecords;
	}
	
	public void add(Page page) {
		pagesRecords.add(page);
	}

	public void setPagesRecords(LinkedList<Page> pagesRecords) {
		this.pagesRecords = pagesRecords;
	}
	public int Size() {
		return pagesRecords.size();
	}
	
	public Page Get(int index) {
		return pagesRecords.get(index);
	}
}
