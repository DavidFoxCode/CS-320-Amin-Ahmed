// Amin Ahmed - Contact.java

public class Contact {

    private final String id; // final so it can't be changed
    private String givenName;
    private String familyName;
    private String phoneNumber;
    private String homeAddress;

    public Contact(String id, String givenName, String familyName, String phoneNumber, String homeAddress) {
        // basic checks, throw IllegalArgumentException if invalid
        if (id == null || id.length() == 0 || id.length() > 10) {
            throw new IllegalArgumentException("id must be 1-10 chars, not null");
        }
        if (givenName == null || givenName.length() == 0 || givenName.length() > 10) {
            throw new IllegalArgumentException("givenName must be 1-10 chars, not null");
        }
        if (familyName == null || familyName.length() == 0 || familyName.length() > 10) {
            throw new IllegalArgumentException("familyName must be 1-10 chars, not null");
        }
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("phoneNumber must be exactly 10 digits, not null");
        }
        if (homeAddress == null || homeAddress.length() == 0 || homeAddress.length() > 30) {
            throw new IllegalArgumentException("homeAddress must be 1-30 chars, not null");
        }

        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    // setters with validation
    public void setGivenName(String givenName) {
        if (givenName == null || givenName.length() == 0 || givenName.length() > 10) {
            throw new IllegalArgumentException("givenName must be 1-10 chars, not null");
        }
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        if (familyName == null || familyName.length() == 0 || familyName.length() > 10) {
            throw new IllegalArgumentException("familyName must be 1-10 chars, not null");
        }
        this.familyName = familyName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("phoneNumber must be exactly 10 digits, not null");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setHomeAddress(String homeAddress) {
        if (homeAddress == null || homeAddress.length() == 0 || homeAddress.length() > 30) {
            throw new IllegalArgumentException("homeAddress must be 1-30 chars, not null");
        }
        this.homeAddress = homeAddress;
    }
}
