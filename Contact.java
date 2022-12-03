package mission2;

import java.util.ArrayList;
import java.util.Objects;

public class Contact implements Comparable<Contact>{
    /**
     * @param name, number
     * use name and number in class for create contact
     */

    String name;
    String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public int compareTo(Contact contact){

        return this.name.compareTo(contact.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return name == contact.name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
