// Amin Ahmed - ContactManager.java

import java.util.LinkedHashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> store;

    public ContactService() {
        store = new LinkedHashMap<>(); // predictable order if you need it
    }

    // add a contact, id must be unique
    public void add(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String key = contact.getId();
        if (store.containsKey(key)) {
            throw new IllegalArgumentException("duplicate id not allowed");
        }
        store.put(key, contact);
    }

    // remove contact by id
    public void removeById(String id) {
        if (id == null || !store.containsKey(id)) {
            throw new IllegalArgumentException("id not found");
        }
        store.remove(id);
    }

    // update individual fields, null means "do not change"
    public void updateById(String id, String newGiven, String newFamily, String newPhone, String newAddress) {
        if (id == null || !store.containsKey(id)) {
            throw new IllegalArgumentException("id not found");
        }
        Contact entry = store.get(id);
        if (newGiven != null) {
            entry.setGivenName(newGiven);
        }
        if (newFamily != null) {
            entry.setFamilyName(newFamily);
        }
        if (newPhone != null) {
            entry.setPhoneNumber(newPhone);
        }
        if (newAddress != null) {
            entry.setHomeAddress(newAddress);
        }
    }

    // helper to check how many contacts we have
    public int totalContacts() {
        return store.size();
    }

    // optional, lets tests fetch a contact (useful for assertions)
    public Contact findById(String id) {
        return store.get(id);
    }
}
