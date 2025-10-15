// Amin Ahmed - ContactManagerTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    
    @Test
    public void addAndCount_shouldWork() {
        ContactService mgr = new ContactService();
        Contact c1 = new Contact("c01", "Amin", "Ahmed", "1112223333", "1 Road St");
        mgr.add(c1);
        assertEquals(1, mgr.totalContacts());
        // duplicate id should fail
        assertThrows(IllegalArgumentException.class, () -> mgr.add(c1));
    }

    @Test
    public void remove_existingAndNonExisting_behaviour() {
        ContactService mgr = new ContactService();
        Contact c = new Contact("c02", "Joe", "Bloggs", "2223334444", "2 Lane");
        mgr.add(c);
        mgr.removeById("c02");
        assertEquals(0, mgr.totalContacts());
        // removing again should throw
        assertThrows(IllegalArgumentException.class, () -> mgr.removeById("c02"));
    }

    @Test
    public void update_fields_changeCorrectly() {
        ContactService mgr = new ContactService();
        Contact c = new Contact("c03", "Sara", "Lee", "3334445555", "3 Ave");
        mgr.add(c);

        mgr.updateById("c03", "Sarah", null, "9998887777", "New Address 123");
        Contact got = mgr.findById("c03");
        assertEquals("Sarah", got.getGivenName());
        assertEquals("Lee", got.getFamilyName());
        assertEquals("9998887777", got.getPhoneNumber());
        assertEquals("New Address 123", got.getHomeAddress());

        // updating a non-existent id should throw
        assertThrows(IllegalArgumentException.class, () -> mgr.updateById("nope", "X", null, null, null));
    }
}
