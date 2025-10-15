// Amin Ahmed - ContactTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void createValidContact_shouldSucceed() {
        Contact x = new Contact("a1", "Amin", "Ahmed", "5551234567", "44 College Ave");
        assertEquals("a1", x.getId());
        assertEquals("Amin", x.getGivenName());
        assertEquals("Ahmed", x.getFamilyName());
        assertEquals("5551234567", x.getPhoneNumber());
        assertEquals("44 College Ave", x.getHomeAddress());
    }

    @Test
    public void invalidId_nullOrTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "A", "B", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "A", "B", "1234567890", "addr"));
    }

    @Test
    public void invalidPhone_wrongLengthOrLetters_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("id1", "A", "B", "12345", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("id2", "A", "B", "abcdefghij", "addr"));
    }

    @Test
    public void setters_withInvalidValues_throw() {
        Contact c = new Contact("id9", "Amin", "Ahmed", "1234567890", "somewhere");
        assertThrows(IllegalArgumentException.class, () -> c.setGivenName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFamilyName("thisnameistoolong"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhoneNumber("000"));
        assertThrows(IllegalArgumentException.class, () -> c.setHomeAddress(null));
    }
}
