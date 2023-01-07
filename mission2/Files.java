package mission2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
    /**
     * method for create file txt by Phonebook class and path for file
     */
    void createFile(PhoneBook phonebook, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            for (Contact contact : phonebook.contacts)
                myWriter.write(contact.name + "," + contact.number + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    /**
     * method for read file to the program
     */
    void readFile(PhoneBook phoneBook) throws FileNotFoundException {
        Scanner input = new Scanner(new File("filename.txt"));

        ArrayList<String> contacts = new ArrayList<>();
        while (input.hasNextLine()){
            contacts.add(input.nextLine());
        }
        System.out.println(contacts);
    }
}

