package mission2;

import java.awt.*;
import java.util.*;

public class Menu extends PhoneBook {
    public Menu(ArrayList<Contact> contacts) {
        super(contacts);
    }

    void listCommands() {
        System.out.println("addContact  - add new contact to the phonebook");
        System.out.println("delContact - delete contact from phonebook");
        System.out.println("allContacts - print all contacts from phonebook");
        System.out.println("searchContact - search contact by name in phonebook");
        System.out.println("sortContact - arrangement of the contacts by name in the telephone book");
        System.out.println("sortContactTel - arrangement of the contacts by phone in the telephone book");
        System.out.println("reverseArray - printing an array list in reverse order");
        System.out.println("duplicateContacts - removing duplicates from the array list");
        System.out.println("saveContacts - saving the contacts in a file according to the user's choice");
        System.out.println("loadContacts - saving the contacts in the phone book from a file received by the user");
    }

    void Scannerprint() {
        System.out.println("PHONE BOOK");
        System.out.println("===========================");
        System.out.println("Type a command or 'exit' to quit:");
        listCommands();

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();


//        while (!line.equals("exit")) {
//            switch (line) {
//                case "addContact":
//                    addContact(contacts, new Contact(line, line));
//                    break;
//                case "allContacts":
//                    allContacts();
//                    break;
//                case "searchContact":
//                    searchContact(contacts, line);
//                    break;
//                case "delContact":
//                    delContact(contacts, line);
//                    break;
//                case "sortContact":
//                    sortContact();
//                    break;
//                case "sortContactTel":
//                    sortContactTel();
//                    break;
//                case "reverseArray":
//                    reverseArray(contacts);
//                    break;
//                case "duplicateContacts":
//                    duplicateContacts(contacts);
//                    break;
////                case "saveContacts":
////                    saveContacts(contacts);
////                    break;
////                case "loadContacts":
////                    loadContacts(contacts);
////                    break;
//                default:
//                    System.out.println("Invalid command!");
//                    break;
//            }
//        }
   }
}
