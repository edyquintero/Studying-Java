package Agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    List <Contact> agenda = new ArrayList<>();

    public boolean addContact(Contact contact) {
        boolean exists = agenda.stream().anyMatch(c -> c.getName().equals(contact.getName()));
        if (exists) {
            return false;
        } else {
            agenda.add(contact);
            return true;
        }
    }

    public List<Contact> showContacts( ) {
        return agenda;
    }

    public Contact searchByName(String contactName) {
        return agenda.stream().filter(contact -> contact.getName().equals(contactName)).findFirst().orElse(null);
    }

    public boolean deleteByName(String contactName) {
        if (agenda.stream().anyMatch(c -> c.getName().equals(contactName))) {
            agenda.removeIf(c -> c.getName().equals(contactName));
            return true;
        } else {
            return false;
        }
    }
}
