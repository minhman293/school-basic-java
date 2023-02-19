package view;

import model.Library;

public class LibraryManagement extends Menu<String> {

	public LibraryManagement (String title, String[] choice) {
		super(title, choice);
	}
	Library lib = new Library();
	
	@Override
	public void execute(int n) {
		lib.readFromFile();
		
		switch(n) {
			case 1 -> {
				lib.printList();
			}
			case 2 -> {
				lib.searchBook();
			}
			case 3 -> {
				lib.addBook();
			}
			default -> {
				return;
			}
		}
	}
}
