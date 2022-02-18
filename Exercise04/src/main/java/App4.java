import java.util.ArrayList;
import java.util.Scanner;

public class App4 {
    //main method
    public static void main(String[] args) {

        // scanner class to get the input from user
        Scanner s = new Scanner(System.in);

        // instance for the library
        LibraryImpl library = new LibraryImpl();

        // To print the menu
        int option = 0;
        while (option != 6) {
            System.out.println("___________________________________________________________");
            System.out.println(
                    "\nChoose option:" + "\n1.Get the list of book written by an author" + "\n2.Authors of given Book"
                            + "\n3.Number of Books written by an author" + "\n4.Books published in a given year"
                            + "\n5.Most Prolific Author that is author who has published maximum books" + "\n6.Exit");
            System.out.println("Please choose the option: ");
            option = s.nextInt();
            switch (option) {
                case 1:
                    s.nextLine();
                    System.out.println("Please choose the display criteria:");
                    System.out.println(
                            "1.Title Alphabetical ascending \n2. Title Alphabetical Descending \n3. Publication year Ascending \n4. Publication year Descending\n5. Rating Ascending\n6. Rating Descending ");
                    int choice = s.nextInt();
                    System.out.println("Please Enter Author Name:");
                    s.nextLine();
                    String authorName = s.nextLine().trim().replaceAll("\\s+", " ");
                    library.displayRecordsOfBookUsingCriteria(choice, authorName);

                    break;

                case 2:
                    System.out.println("Please Enter the Book Name to Get Its Author: ");
                    s.nextLine();
                    String bookName = s.nextLine().trim().replaceAll("\\s+", " ");
                    ArrayList<String> authorsList = library.getAuthorsFromBookName(bookName);
                    if (authorsList.size() == 0) {
                        System.out.println("No author for the book because you have entered wrong book name");
                    } else {
                        System.out.println("Authors of book " + bookName + " :");
                        for (String author : authorsList) {
                            System.out.println(author);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the Author Name:");
                    s.nextLine();
                    String name = s.nextLine().trim().replaceAll("\\s+", " ");
                    Author findAuthor = library.findAuthor(name);
                    if (findAuthor == null) {
                        System.out.println("Sorry Author is not in our list");
                    } else {
                        System.out.println(name + " has written " + findAuthor.getAllBooks().size() + " books.");
                    }
                    break;
                case 4:
                    System.out.println("Please Enter the Valid Year");
                    s.nextLine();
                    int year = s.nextInt();
                    ArrayList<String> bookList = library.writtenAllBooksInTheYear(year);

                    if (bookList != null) {
                        if (bookList.size() == 0) {
                            System.out.println("None of the book published in year " + year);
                        } else {
                            System.out.println("Books published in year " + year + " :");
                            for (String bookname : bookList) {
                                System.out.println(bookname);
                            }
                        }
                    }
                    break;

                case 5:
                    library.profilicAuthor();
                    break;
                case 6:
                    System.out.println("Exit");
                    s.close();
                    option = 6;
                    break;

                default:
                    System.out.println("You have entered wrong option..please enter valid option");
                    break;

            }
        }
    }
}
