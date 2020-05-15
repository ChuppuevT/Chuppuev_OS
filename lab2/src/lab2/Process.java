package lab2;

import java.util.ArrayList;

public class Process {

	private Status status;
	private String ProcessName;
	private int quantProcess;
	private int threadsTime;
	ArrayList<Thread> threadArrayList;
	Kernel Kernel;

	public Process(int time, String ProcessName, Kernel Kernel){
		this.Kernel = Kernel;
		this.status = Status.Готов;
		this.quantProcess = time;
		this.ProcessName = ProcessName;
		int count = 3;
		int qunt = time / count;
		threadArrayList = new ArrayList<Thread>();

		for (int i = 0; i < count; i++) {
			Thread thread = new Thread();
			thread.setQuant(qunt);
			thread.setName(ProcessName + " " + "Thread " + (i + 1));
			threadArrayList.add(thread);
			ThreadsTime();
		}
	}

	public void ThreadsTime() {
		threadsTime = 0;
		for(int i = 0 ; i < threadArrayList.size(); i++){
			threadsTime += threadArrayList.get(i).getTime();
		}
	}

	public Status getStat() {
		return status;
	}

	public String getName() {
		return ProcessName;
	}

	public int getTime() {
		return threadsTime;
	}

	public ArrayList<Thread> getThreads() {
		return threadArrayList;
	}

	public void setStat(Status status){
		System.out.print(ProcessName + ": из " + this.status + " в ");
		this.status = status;
		System.out.println(status);
	}

	public void Work() {
		Kernel.RunThreads(threadArrayList);
		threadsTime = threadsTime - quantProcess;
		if(threadsTime <= 0) {
			Kernel.RunThreads(threadArrayList);
			setStat(Status.Запущен);
			return;
		}
		setStat(Status.Завершен);
	}
}
