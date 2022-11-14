package mission2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class PhoneBook{
    /**
     *
     */

    ArrayList<Contact> contacts;
    private static final String DATA_PATH = "src/contacts.csv";

    public PhoneBook(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }

    void list()
    {
        if( this.contacts.isEmpty() )
        {
            System.out.println("The phonebook is empty");
        }
    }

    void addContact(ArrayList<Contact> contacts, Contact newContact){
        this.contacts.add(newContact);
        allContacts();

    }

    void delContact(ArrayList<Contact> contacts , String name) {
        list();
        for (int i = 0; i < contacts.size(); i++) {
            String s = contacts.get(i).name;
            if (name == s) {
                contacts.remove(i);
            } else {
                System.out.println("you don't have contact in this name");
            }
            break;
        }
        allContacts();
    }

    void allContacts(){
        list();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
    }

    void searchContact(ArrayList<Contact> contacts, String name){
        list();
        for (int i = 0; i < contacts.size(); i++) {
            String s = contacts.get(i).name;
            if (name == s) {
                System.out.println("My name is: " + contacts.get(i).name + " My number is: " + contacts.get(i).number );
            } else {
                System.out.println("you don't have contact in this name");
            }
            break;
        }
    }

    void sortContact() {
        list();
        for (int i = 0; i < contacts.size(); i++) {
            Collections.sort(contacts);
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
        System.out.println("If you put characters in the name to protest the letters, we will remove them dipolatively, you should pay attention");
    }

    void sortContactTel() {
        list();
        for (int i = 0; i < contacts.size(); i++) {
            Collections.sort(contacts);
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
        System.out.println("If you put characters in the name to protest the letters, we will remove them dipolatively, you should pay attention");
    }

    void reverseArray(ArrayList<Contact> contacts){
        System.out.println("Original array: ");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
        System.out.println();
        System.out.println("Array in reverse order: ");
        //Loop through the array in reverse order
        for (int i = contacts.size()-1; i >= 0; i--) {
            System.out.println("My name is: " + removeNumeric(contacts.get(i).name) + " " + " My number is: " +  contacts.get(i).number);
        }
    }

    void duplicateContacts(ArrayList<Contact> contacts){
        System.out.println("List with Duplicates");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println(contacts.get(i).name);
        }

        List<Contact> uniqueUser = contacts.stream().distinct().collect(Collectors.toList());

        System.out.println("List without duplicates: ");
        for(int i = 0; i < uniqueUser.size(); i++) {
            System.out.println(uniqueUser.get(i).name);
        }
        System.out.println("The name is duplicate: " + uniqueUser.iterator().next().name);
    }

     void saveContacts(Map<String, ArrayList<Contact>> contacts) {
        try (PrintWriter writer = new PrintWriter(DATA_PATH)) {
            if (!contacts.isEmpty()) {
                for (Map.Entry<String, ArrayList<Contact>> entry : contacts.entrySet()) {
                    String line = String.format("%s,\"%s\"",
                            entry.getKey(), entry.getValue().toString().replaceAll("\\[|]", ""));
                    writer.println(line);
                }
            }

        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
    }

    void loadContacts(Map<String, List<String>> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PATH))) {

            Pattern pattern = Pattern.compile("^([^,\"]{2,50}),\"([0-9+, ]+)\"$");

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String[] numbers = matcher.group(2).split(",\\s*");
                    contacts.put(matcher.group(1), Arrays.asList(numbers));
                }
            }

        } catch (IOException ioex) {
            System.err.println("Could not load contacts, phone book is empty!");
        }
    }

    public static String removeNumeric(String str)
    {
        return str.chars()            // or `codePoints()`
                .filter(ch -> Character.isAlphabetic(ch))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public static void main(String[]args){
        Contact c = new Contact("tmit" , "054326788578");
        Contact ca = new Contact("@ibi" , "0543255");
        Contact ce = new Contact("cmdfjfkdk" , "0543266");
        Contact cg = new Contact("golan" , "0543");


        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(c);
        contacts.add(ca);
        contacts.add(ce);
        contacts.add(cg);
        PhoneBook p = new PhoneBook(contacts);

        p.duplicateContacts(contacts);
        p.saveContacts((Map<String, ArrayList<Contact>>) contacts);

    }
}

