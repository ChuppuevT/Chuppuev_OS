package lab3;
import java.util.ArrayDeque;
import java.util.Random;

public class Main {
	private ArrayDeque<Page> times;
	private Process processes;
	private static Random random = new Random();
	
	public static void main(String[] args) {
		OS os = new OS(16, 4);
		for (int processId = 0; processId < random.nextInt(1) + 5; processId++) {
			os.addProcess();
			for (int pageId = 0; pageId < os.receiveProcess(processId).receiveCountpages(); pageId++) {
				os.addPage(processId);
			}
			os.printMemory();
		}
		os.printMemory();
	}
	public Main() {
		times = new ArrayDeque<>();
		processes = new Process(10, 30);
	}
	public Page receivePages(int pageid) {
		Page page = processes.receivePage(pageid);
		if (page.isPresence()) {
			page.setRecourse(true);
		} else {
			int emptyPageId = OS.memory.receiveEmptyPageid();
			if (emptyPageId != -1) {
				OS.memory.setPage(emptyPageId, page);
				page.setRecourse(true);
				page.setPresence(true);
				page.setPhysicalAddress(emptyPageId);
				this.times.addLast(page);
			} else {
				while (true) {
					Page replacePage = this.times.pollFirst();
					if (replacePage.isRecourse()) {
						replacePage.setRecourse(false);
						this.times.addLast(replacePage);
					} else {
						if (replacePage.receiveVirtualAddress() != -1) {
							OS.memory.setPage(replacePage.receivePhysicalAddress(),
									OS.receivePage(replacePage.receiveVirtualAddress()));
						} else {
							OS.memory.setPage(replacePage.receivePhysicalAddress(), page);
						}
						page.setRecourse(true);
						page.setPresence(true);
						page.setPhysicalAddress(replacePage.receivePhysicalAddress());
						this.times.addLast(page);
						replacePage.setPresence(false);
						replacePage.setVirtualAddress(OS.addPage(replacePage));
						replacePage.setPhysicalAddress(-1);
						break;
					}
				}
			}
		}
		return page;
	}

	public int addPage(Process process) {
		int pageid = processes.addPage(new Page(process.receiveId()));
		process.receivePagesId().add(pageid);
		this.receivePages(pageid);
		return pageid;
	}
}
