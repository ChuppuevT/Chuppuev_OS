package lab2;
import java.util.ArrayList;

public class Kernel {

	private ArrayList<Process> ProcessArrayList;
	ArrayList<Thread> threadArrayList;
	int timeThreads;
	private int time;

	public Kernel(int time){
		threadArrayList = new ArrayList<Thread>();
		int count = 2;
		ProcessArrayList = new ArrayList<Process>();

		for(int i = 0; i < count; i++) {
			Process Process = new Process(time, "Process" + (i + 1), this);
			ProcessArrayList.add(Process);
		}
	}

	private void processTime(){
		time = 0;
		for (Process Process: ProcessArrayList) {
			time += Process.getTime();
		}
	}

	public void RunProcess(){
		for (Process Process: ProcessArrayList) {
			if(Process.getStat() == Status.Готов) {
				Process.setStat(Status.Запущен);
				Process.Work();
			}
		}
	}

	public void RunThreads(ArrayList<Thread> threadArrayList) {
		for (Thread thread: threadArrayList) {
			if(thread.getStat() == Status.Готов){
				thread.setStat(Status.Запущен);
				thread.Work();
			}
		}
	}

	public boolean CheckAll(){
		processTime();
		if(time <= 0){
			return true;
		}
		return false;
	}
}