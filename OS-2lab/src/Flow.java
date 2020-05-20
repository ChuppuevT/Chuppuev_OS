
import java.util.Random;

public class Flow {
	private String name;
	private int curTime;
	private int finishTime;
	
	public Flow(String name) {
		this.name = name;
		generateRandomFlow();
		printFlow();
	}

	private void generateRandomFlow() {
		Random rnd = new Random();
		finishTime = rnd.nextInt(10)+1;
	}

	public void printFlow() {
		System.out.println("поток:" +name+ " время: " +curTime+ " время завершения: " +finishTime);
	}

	public String getName() {
		return name;
	}
	
	public Boolean startWork(int timeForWork) {
		if(curTime+timeForWork >= finishTime) {
			curTime = finishTime;
			return true;
		} else {
			curTime+=timeForWork;
			return false;
		}
	}

}
