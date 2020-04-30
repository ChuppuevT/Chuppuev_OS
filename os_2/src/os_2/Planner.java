package os_2;

import java.util.ArrayList;
import java.util.Random;

public class Planner {
	private  ArrayList<Process> myProcesses = new ArrayList<Process>();
	private Random rand = new Random();
	private int quant = 10;
	
	public void create() {
		for (int i = 0; i < rand.nextInt(5) + 1; i++) {
			myProcesses.add(new Process("" + i, rand.nextInt(50) + 1));
		}
		
		for (int i = 0; i < myProcesses.size(); i++) {
			System.out.println(myProcesses.get(i).getDescription() + " Кол во-потоков " + myProcesses.get(i).getCountOfThreads());
		}
		System.out.println();
	}
	
	public void start() {		
		while (!myProcesses.isEmpty()) {
			int sizeProcesses = myProcesses.size();
			for (int i = 0; i < sizeProcesses; i++) {
				if (myProcesses.get(i).isHaveTime()) {
					if (!myProcesses.get(i).isEmpty()) {
						Execute(i);
					} else {
						System.out.println("Все потоки " + myProcesses.get(i).getDescription() + "  выполнены");
						myProcesses.remove(i);
						sizeProcesses = myProcesses.size();
						i--;
					}
				} else {
					myProcesses.remove(i);
					sizeProcesses = myProcesses.size();
					i--;
				}
			}
		}
		System.out.println("Все процессы выполнены");
	}
	public void Execute(int index) {
		if(quant>0) {
			for (int i = 0, iq = 0; i < myProcesses.get(index).Amount(); i++, iq++) {
				Thread thread = myProcesses.get(index).Lists(i);
				int thQuant = quant / myProcesses.get(index).Amount();
				if (iq < quant % myProcesses.get(index).Amount()) {
					thQuant++;
				}
				if (!thread.needTime()) {
					System.out.println(thread.getDescription() + " завершен");
					myProcesses.get(index).procKiller(i);				
					i--;
					break;
				}
				while (thQuant > 0) {
					if (thread.needTime() & myProcesses.get(index).isHaveTime() & thQuant > 0) {
						thread.makeThread();
						thQuant--;
						myProcesses.get(index).setResultTime();
					}
					if (!thread.needTime()) {
						System.out.println(thread.getDescription() + " завершен");
						myProcesses.get(index).procKiller(i);						
						i--;
						break;
					}
					if (!myProcesses.get(index).isHaveTime()) {
						System.out.println("максимальное время " + myProcesses.get(index).getDescription() + " завершен");
						return;
					}
					if (thQuant <= 0) {
						System.out.println("квант на " + thread.getDescription() + " истек");
						break;
					}				
				}
			}
		}
		else {
			System.out.println("Данный квант времени меньше 1");
			System.exit(0);
		}
		
	}
}
