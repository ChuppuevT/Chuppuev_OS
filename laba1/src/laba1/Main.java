package laba1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Stack<SysCall> st = new Stack<>();
		final Core core = new Core(st);
		
		System.out.println("������: ");
		core.com();
		
		st.push(new SysCall(0, "����� "+ 0 + "-� ", "Copy"));
		core.call(0);
		st.push(new SysCall(0, "����� "+ 0 + "-� ", "Copy"));
		core.call(1);
	}
}
