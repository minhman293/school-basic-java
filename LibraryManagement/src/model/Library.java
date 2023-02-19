package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import view.Menu;

public class Library {
    ArrayList<Book> BookList = new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return this.BookList;
    }

    public void setBookList(ArrayList<Book> BookList) {
        this.BookList = BookList;
    }

    public Library() {}
    

	public Library(ArrayList<Book> bookList) {
		super();
		BookList = bookList;
	}

	public void readFromFile() {
        File f = new File("/Volumes/Seagate/seagate_temp/CODE_UTE/OOP_JAVA/LibraryManagement/lib.txt");
        try {
            List<String> Lines = Files.readAllLines(f.toPath());
            for (String line : Lines) {
                String[] text = line.split("[:]");
                String bookid = text[0];
                String booktitle = text[1];
                String author = text[2];
                int year = Integer.parseInt(text[3]);

                Book bk = new Book(bookid, booktitle, author, year);
                BookList.add(bk);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void printList() {
        for (Book i : BookList) {
            System.out.println(i.toString());
        }
    }

    public void searchID(String id) {
    	int cnt = 0;
    	System.out.println("List of Books");
    	System.out.println("-------------------");
    	for (Book i : BookList) 
    		if (i.cmpID(id)) {
    			cnt++;
    			System.out.println("Book{" + i.getBookID() + " - " + i.getBookTitle() + " - " + i.getAuthor() + " - " + i.getYearPublished() + "}");
    		}
    	System.out.println("-------------------");
    	System.out.println("Total : " + cnt + " books");
    	
    }
    
    public void searchTitle(String t) {
    	int cnt = 0;
    	System.out.println("List of Books");
    	System.out.println("-------------------");
    	for (Book i : BookList)
    		if (i.cmpTitle(t)) {
    			cnt++;
    			System.out.println("Book{" + i.getBookID() + " - " + i.getBookTitle() + " - " + i.getAuthor() + " - " + i.getYearPublished() + "}");
    		}
    	System.out.println("-------------------");
    	System.out.println("Total : " + cnt + " books");
    }
    
    public void searchAuthor(String a) {
    	int cnt = 0;
    	System.out.println("List of Books");
    	System.out.println("-------------------");
    	for (Book i : BookList)
    		if (i.cmpAuthor(a)) {
    			cnt++;
    			System.out.println("Book{" + i.getBookID() + " - " + i.getBookTitle() + " - " + i.getAuthor() + " - " + i.getYearPublished() + "}");
    		}
    	System.out.println("-------------------");
    	System.out.println("Total : " + cnt + " books");
    }
    
    public void searchYear(int y) {
    	int cnt = 0;
    	System.out.println("List of Books");
    	System.out.println("-------------------");
    	for (Book i : BookList)
    		if (i.cmpYear(y)) {
    			cnt++;
    			System.out.println("Book{" + i.getBookID() + " - " + i.getBookTitle() + " - " + i.getAuthor() + " - " + i.getYearPublished() + "}");
    		}
    	System.out.println("-------------------");
    	System.out.println("Total : " + cnt + " books");
    }
    
    public class MenuSearch extends Menu{
    	
    	public MenuSearch(String td, String[] mc) {
    		super(td, mc);
    	}
    	
    	@Override
    	public void run(){
    		int n=getSelected();
            execute(n);
            if(n>mChon.size()) return;
    	}
    	
		@Override
		public void execute(int n) {
			Scanner sc = new Scanner(System.in);
			switch(n) {
				case 1 -> {
					System.out.print("Enter BookID: ");
					searchID(sc.nextLine());
				}
				case 2 -> {
					System.out.println("Enter Book Title: ");
					searchTitle(sc.nextLine());
				}
				case 3 -> {
					System.out.println("Enter Author: ");
					searchAuthor(sc.nextLine());
				}
				case 4 -> {
					System.out.println("Enter Year Publish: ");
					searchYear(Integer.parseInt(sc.nextLine()));
				}
			}
			
		}
    	
    }
    
    public void searchBook() {
    	String[] searchChoices = {
    			"Find by BookID", "Find by Title", 
    			"Find by Author", "Find by Year of publishing"
    	};
    	MenuSearch mns = new MenuSearch("Book Searching", searchChoices);
    	mns.run();
    	
    }
    
    public void addBook() {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Add new book");
    	System.out.println("----------------");
    	System.out.print("BookID: ");
    	String id = sc.nextLine();
    	System.out.print("Title: ");
    	String t = sc.nextLine();
    	System.out.print("Author: ");
    	String a = sc.nextLine();
    	System.out.print("Year publish: ");
    	int y = sc.nextInt();
    	
    	Book bk = new Book(id, t, a, y);
    	this.BookList.add(bk);
    }
}
