package os_2;

public class Thread {
	private String description = "����� ";
	private int maxTime;
	private int currentTime = 0;
	

	public Thread(String description, int maxTime) {
		this.description += description;
		this.maxTime = maxTime;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public String getDescription() {
		return description;
	}

	public void makeThread() {
		currentTime++;
		System.out.println(getInfo());
	}

	public boolean needTime() {
		return maxTime > currentTime? true:false;
	}

	public String getInfo() {
		return description + " maxTime:" + maxTime + " currentTime:" + currentTime;
	}
}
