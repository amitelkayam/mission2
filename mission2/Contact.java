package mission2;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    /**
     * @param name, number
     * use name and number in class for create contact
     * create getters and setters for call or set parameters
     */

    String name;
    String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String newNumber){
        this.number = newNumber;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return name.equals(contact.name) && number.equals(contact.number);
    }

    /**
     * use hashCode method for collecstion sort in PhoneBook class
     * use to string class for use print all contacts
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(name,number);
    }

    @Override
    public String toString() {
        return "My name is: " + name + "  " + "My number is: " + number;
    }
}
