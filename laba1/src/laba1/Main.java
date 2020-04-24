package laba1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Stack<SysCall> st = new Stack<>();
		final Core core = new Core(st);
		
		System.out.println("ֲûחמגû: ");
		core.com();
		
		st.push(new SysCall(0, "ֲûחמג "+ 0 + "-י ", "Copy"));
		core.call(0);
		st.push(new SysCall(0, "ֲûחמג "+ 0 + "-י ", "Copy"));
		core.call(1);
	}
}
