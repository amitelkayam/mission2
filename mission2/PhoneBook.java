package mission2;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook{
    /**
     * @param array list of contacts for use with array to run method
     */

    ArrayList<Contact> contacts;

    //constructor for started the arraylist
    public PhoneBook(){
        this.contacts = new ArrayList<>();
    }

    /**
     * method for checking if arraylist is empty
     */
    void isEmpty()
    {
        if( this.contacts.isEmpty() )
        {
            System.out.println("The phonebook is empty");
        }
    }

    /**
     * method for use print all functions for user in main class
     */
    public void menuCall(){
        System.out.println("Type a command or 'exit' to quit:");
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
        System.out.print("\n> ");
    }

    /**
     * method for print all contacts in arraylist
     */
    void allContacts(){
        isEmpty();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
    }

    /**
     * method for add new contact to arraylist
     */
    void addContact(Contact newContact){
        this.contacts.add(newContact);
    }

    /**
     * method for delete contact by name if doesn't have any contact the user get message
     */
    void delContact(String name) {
        isEmpty();
        boolean booleany = false;
        String s = "";
        for (int i = 0; i < contacts.size(); i++) {
            s = contacts.get(i).name;
            if (s.equals(name)) {
                contacts.remove(i);
                booleany = true;
                allContacts();
            }
        }
        if(booleany == false){
            System.out.println("you don't have any contact with this name");
        }
    }

    /**
     * method for searching contact by name if doesn't have any contact the user get message
     */
    void searchContact(String name){
        isEmpty();
        boolean booleany = false;
        String s = "";
        for (int i = 0; i < contacts.size(); i++) {
            s = contacts.get(i).name;
            if (s.equals(name)) {
                booleany = true;
                System.out.println("My name is: " + contacts.get(i).name + " My number is: " + contacts.get(i).number );
            }
        }
        if(booleany == false){
            System.out.println("you don't have any contact with this name");
        }
    }

    /**
     * method for sort by collectors according to name
     */
    void sortContact() {
        isEmpty();
        System.out.println("before collections sort by name: ");
        allContacts();
        System.out.println("-------------------------------------------------------");
        Collections.sort(contacts, Comparator.comparing(Contact:: getName));
        System.out.println("after collections sort by name:");
        allContacts();
    }

    /**
     * method for sort by collectors according to phone
     */
    void sortContactTel() {
        isEmpty();
        System.out.println("before collections sort by number: ");
        allContacts();
        System.out.println("-----------------------------------------------------------------");
        Collections.sort(contacts, Comparator.comparing(Contact:: getNumber));
        System.out.println("after collections sort by number:");
        allContacts();
    }

    /**
     * method for reverse arraylist
     */
    void reverseArray(){
        isEmpty();
        System.out.println("Original array: ");
        allContacts();
        System.out.println();
        System.out.println("Array in reverse order: ");
        //Loop through the array in reverse order
        for (int i = contacts.size()-1; i >= 0; i--) {
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
    }

    /**
     * method for duplicates by distinct method, create new arraylist and equals between contacts to the new arraylist
     */
    void duplicateContacts(){
        isEmpty();
        System.out.println("before duplicates: ");
        allContacts();

        List<Contact> uniqueUser = contacts.stream().distinct().collect(Collectors.toList());

        System.out.println("List without Duplicates");
        System.out.println(uniqueUser);
    }

    /**
     * method for remove numeric chars from string
     */
    public static String removeNumeric(String str)
    {
        return str.chars()            // or `codePoints()`
                .filter(ch -> Character.isAlphabetic(ch))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

//    public static void main(String[]args){
//        Contact c = new Contact("tmit" , "2543");
//        Contact ca = new Contact("@ibi" , "1543255");
//        Contact ce = new Contact("cmdfjfkdk" , "0543266");
//        Contact cg = new Contact("tmit" , "2543");
//
//
//        ArrayList<Contact> contacts = new ArrayList<>();
//
//        PhoneBook p = new PhoneBook();
//        p.addContact(c);
//        p.addContact(ca);
//        p.addContact(ce);
//        p.addContact(cg);
//        p.duplicateContacts();
//    }
}

