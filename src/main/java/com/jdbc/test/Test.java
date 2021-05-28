package com.jdbc.test;

public class Test {
	public static void main(String[] args) {

		App aa = new App();

		// aa.update(104,"krishn","M");
		System.out.println("Emp table updated");

		/*
		 * try { aa.read(); } catch (ClassNotFoundException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		aa.create();
	}
}
