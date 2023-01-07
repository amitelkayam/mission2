package mission2;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * started the arraylist and p obj from PhoneBook and f from Files
         */
        ArrayList<Contact> contacts = new ArrayList<>();

        PhoneBook p = new PhoneBook();
        Files f = new Files();

        System.out.println("PHONE BOOK: ");
        System.out.println("===========================");
        System.out.println("Type a command or 'exit' to quit:");
        System.out.println(" ");
        System.out.println("1 - addContact  - add new contact to the phonebook");
        System.out.println("2 - delContact - delete contact from phonebook");
        System.out.println("3 - allContacts - print all contacts from phonebook");
        System.out.println("4 - searchContact - search contact by name in phonebook");
        System.out.println("5 - sortContact - arrangement of the contacts by name in the telephone book");
        System.out.println("6 - sortContactTel - arrangement of the contacts by phone in the telephone book");
        System.out.println("7 - reverseArray - printing an array list in reverse order");
        System.out.println("8 - duplicateContacts - removing duplicates from the array list");
        System.out.println("9 - saveContacts - saving the contacts in a file according to the user's choice");
        System.out.println("10 - loadContacts - saving the contacts in the phone book from a file received by the user");
        System.out.println("11 - exit - Finishing the program");
        System.out.print("> ");

        boolean exit = false;
        int pointer = 0;
        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        /**
         * use while loops and case for the menu for user get input from user and compile the functions from another classes
         * if the user want close the program they have exit option
         * if the program get 3 exception from user the program stop
         */
        while (!exit) {

            switch (line) {
                case "1":
                    p.addContact(new Contact(input.nextLine(),input.nextLine()));
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "2":
                    p.delContact(input.nextLine());
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "3":
                    p.allContacts();
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "4":
                    p.searchContact(input.nextLine());
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "5":
                    p.sortContact();
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "6":
                    p.sortContactTel();
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "7":
                    p.reverseArray();
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                    break;
                case "8":
                    p.duplicateContacts();
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                case "9":
                    f.createFile(p, "filename.txt");
                    System.out.println("press enter for return to menu");
                    input.nextLine();
                    p.menuCall();
                    line = input.nextLine().trim();
                case "10":
                    f.readFile(p);
                case "11":
                    exit = true;
                    System.out.println("Exiting the phone book");
                    break;
                default:
                    if(pointer == 3){
                        exit = true;
                        System.out.println("Exiting the phone book");
                    }else{
                        System.out.println("Sorry the option you've chosen is not available");
                        pointer++;
                        System.out.println("Press ENTER to return to the main menu");
                        Scanner input1 = new Scanner(System.in);
                        input1.nextLine();
                    }
                    System.out.println("Invalid command!");
                    break;
            }

        }
        System.out.println("amit's phone book version 1");
    }
}

