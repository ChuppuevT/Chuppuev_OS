package lab3;

public class Memory {
	private Page[] pages;

	public Memory(int sizememory, int sizepage) {
		pages = new Page[sizememory / sizepage];
	}
	
	public void setPage(int pageid, Page page) {
		pages[pageid] = page;
	}
	
	public Page receivePage(int pageId) {
		return pages[pageId];
	}
	
	public int receiveCountpages() {
		return pages.length;
	}

	public int receiveEmptyPageid() {
		for (int index = 0; index < pages.length; index++) {
			if (pages[index] == null) {
				return index;
			}
		}
		return -1;
	}
}

