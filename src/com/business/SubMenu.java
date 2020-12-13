package com.business;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidNumberException;

public class SubMenu implements BusinessLogic{
	
	private List<String> list;
	
	private String dir;
	
	public SubMenu(List<String> list, String dir) {
		this.list = list;
		this.dir = dir;
	}

	@Override
	public void prompt() {
		System.out.println("1. Add File\n"
				+ "2. Delete File\n"
				+ "3. Search File\n"
				+ "4. Return To Menu\n");
	}

	@Override
	public int choices(int n) throws InvalidNumberException {
		try {
			if (n == 1) {
				addFile();
			}
			else if (n == 2) {
				deleteFile();
			}
			else if (n == 3) {
				searchFile();
			}
			else if (n == 4) {
				return n;
			}
			else {
				throw new InvalidNumberException("Please enter a valid range.\n");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return n;
	}

	private void addFile() throws IOException {
		String str = input();
		File file = new File(dir + str);
		file.createNewFile(); 
		if (!list.contains(str)) {
			list.add(str);
			System.out.println("Adding " + str + "\n");
		}
	}
	
	private void deleteFile() {
		String str = input();
		File file = new File(dir + str);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str)) {
				list.remove(i);
				System.out.println("Deleting " + str + "\n");
				return;
			}
		}
		System.out.println("File not found!\n");
	}

	private void searchFile() {
		String str = input();
		try {
			if (list.get(list.indexOf(str)).equals(str)) {
				System.out.println(str + " has been found!\n");
			}
	
		} catch(Exception e) {
			System.out.println(str + " does not exist!\n");
		}
	}

	private String input() {
		System.out.println("Enter File Name:");
		String str = new Scanner(System.in).nextLine();
		while (!str.contains(".")) {
			System.out.println("Invalid file name. Please try again: \n");
			str = new Scanner(System.in).nextLine();
		}
		return str;
	}
}
