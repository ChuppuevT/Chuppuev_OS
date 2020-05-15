package lab2;

public class Thread {
	private Status status;
	private int quant;
	private String Name;
	private int time;
	public Thread(){
		status = Status.Готов;
	}

	public String getName() {
		return Name;
	}

	public int getTime() {
		return time;
	}

	public Status getStat() {
		return status;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setQuant(int quant) {
		this.quant = quant;
		this.time = (int)(Math.random() * (quant + 40));
	}

	public void setStat(Status status){
		System.out.print(Name + ": из " + this.status + " в ");
		this.status = status;
		System.out.println(status);
	}

	public void Work() {
		time = time - quant;
		if(time <= 0 ) {
			setStat(Status.Завершен);
			return;
		}
		setStat(Status.Готов);
	}
}