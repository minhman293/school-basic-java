import view.LibraryManagement;

public class Main {
	public static void main(String[] args) {
		String[] lib_choices = {"List all books", "Search book", "Add new Book", "Exit"};
		LibraryManagement LM = new LibraryManagement("Library Management", lib_choices);
		LM.run();
	}
}
