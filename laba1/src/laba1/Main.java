package laba1;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Stack<SysCall> st = new Stack<>();
		final Core core = new Core(st);
		Scanner scr = new Scanner(System.in);
		String argum = "";
		int id = 1000000;

		System.out.println("������: ");
		core.com();

		System.out.println("������� id ������:");
		try {
			id = Integer.parseInt(scr.next());
		} catch (NumberFormatException e) {
			System.out.println("ID ������ ���� ����� ������");
		}

		System.out.println("������� ��������� ������:");
		argum = scr.next();

		st.push(new SysCall(id, "����� "+ id + "-� ", argum));
		core.call(id);

		scr.close();
	}
}
