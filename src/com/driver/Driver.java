package com.driver;

import java.util.Scanner;

import com.business.BusinessLogic;
import com.business.MainMenu;

public class Driver {

	public static void main(String[] args) throws Exception {
		BusinessLogic mainMenu = new MainMenu();
		while (true) {
			run(mainMenu);
		}
	}
	public static void run(BusinessLogic mainMenu) throws Exception {
		try {
			mainMenu.prompt();
			int n = new Scanner(System.in).nextInt();
			mainMenu.choices(n);
		} catch(Exception e) {	
			System.out.println("Invalid input. Please enter a number\n");
		}
	}
}
