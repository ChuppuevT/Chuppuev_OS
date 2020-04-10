package laba1;

import java.util.ArrayList;
import java.util.Stack;

public class Core {
	ArrayList<SysCall> lis = new ArrayList<SysCall>();
	Stack<SysCall> args;

	public Core(Stack<SysCall> args) {
		this.args = args;
	}

	public void com() {
		lis.add(new SysCall(0, "Вызов 0", "Copy"));
		lis.add(new SysCall(1, "Вызов 1", "Past"));
		lis.add(new SysCall(2, "Вызов 2", "Del"));
		lis.add(new SysCall(3, "Вызов 3", "Inp"));
		lis.add(new SysCall(4, "Вызов 4", "Read"));
		spisok(lis.size());
	}

	public void spisok(int size) {
		for (int num = 0; num < size; num++ ) {
			System.out.println("ID: " + lis.get(num).gId());
			System.out.println("Name: " + lis.get(num).gName());
			System.out.println("Argument: " + lis.get(num).gArgs());
			System.out.println("_________________________");
		}
	}

	public void call(int num) {
		int size = lis.size();
		if (num < 0 || num > size) {
			System.out.println("Нет вызова с таким индификатором");
		} else {
			String tmp = args.pop().gArgs().toString();
			if (tmp.length() == lis.get(num).gArgs().length()) {
				if ((tmp.compareTo(lis.get(num).gArgs().toString())) != 0)
				{
					System.out.println("Разные аргументы!");
				}
				else {
					System.out.println("Выполнено");
				}
			} else {
				System.out.println("Разные аргументы!");
			}
		}
	}
}