package com.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidNumberException;

public class MainMenu implements BusinessLogic{

	private List<String> list;
	
	private String dir;
	
	public MainMenu() {
		list = new ArrayList<String>();
		init();
	}
	
	private void init() {
		System.out.println("Welcome to Company Lockers Pvt. Ltd\n"
				+ "Developed by Kevin Lu\n");
		preprocess();
	}
	
	private void preprocess() {
		System.out.println("Please enter a directory or type 1 for default directory: \n");
		dir = new Scanner(System.in).nextLine();
		if (dir.equals("1")) {
			dir = "C:\\Users\\kevin.lu\\eclipse-workspace\\Assessment1";
		}
		String[] fileList = new File(dir).list();
	    for(String s : fileList) {
	    	list.add(s);
	    }		
	}
	
	public void prompt() {
		System.out.println("1. Retrieve all File Names\n"
				+ "2. Add, Delete, Search Files\n"
				+ "3. Close Application\n");
	}
	
	public int choices(int n) throws InvalidNumberException {
		try {
			if (n == 1) {
				searchAllFiles();
			}
			else if (n == 2) {
				while (run());
			}
			else if (n == 3) {
				exitMenu();
			}
			else {
				throw new InvalidNumberException("Please enter a valid range.\n");
			}		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return n;
	}
	
	private boolean run() throws Exception {
		BusinessLogic subMenu = new SubMenu(list, dir);
		try {
			subMenu.prompt();
			int n = new Scanner(System.in).nextInt();
			if (subMenu.choices(n) == 4) {
				return false;
			}
		} catch(Exception e) {	
			System.out.println("Invalid input. Please enter a number\n");
		}
		return true;
	}

	public void searchAllFiles() {
		list.sort((s1, s2) -> s1.compareTo(s2));
		
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println();
	}

	private void exitMenu() {
		System.out.println("Exiting System...");
		System.exit(0);
	}
}
