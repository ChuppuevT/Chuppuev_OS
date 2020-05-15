package lab2;

public class Main {
	public static void main(String[] args) {
		Kernel kernel = new Kernel(100);
		while (!kernel.CheckAll()){
			kernel.RunProcess();
		}
	}
}
