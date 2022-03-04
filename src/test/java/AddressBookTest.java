import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook adb = null;
    private BuddyInfo bud = null;
    private BuddyInfo bud2 = null;

    @Before
    public void setUp() throws Exception {
        adb = new AddressBook();
        bud = new BuddyInfo("Aubin", "343...");
        bud2 = new BuddyInfo("Aub", "613...");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBuddy() {
        adb.addBuddy(bud);
        assertEquals("Should return true", true, adb.contains(bud));
    }

    @Test
    public void removeBuddy() {
        adb.addBuddy(bud);
        assertEquals("Should return true", true, adb.contains(bud));
        adb.removeBuddy(0);
        assertEquals("Should return false", false, adb.contains(bud));
    }

    @Test
    public void testToString() {
        adb.addBuddy(bud);
        assertEquals("This should return Name: Aubin, Phone Number: 613... \n", "Name: Aubin, Phone Number: 343...\n", adb.toString());
    }

    @Test
    public void size() {
        adb.addBuddy(bud);
        adb.addBuddy(bud2);
        assertEquals("Should return 1", 2, adb.size());
    }

    @Test
    public void clear() {
        adb.addBuddy(bud);
        adb.clear();
        assertEquals("Should return false", false, adb.contains(bud));
        assertEquals("Should return 0", 0, adb.size());
    }
    @Test
    public void testEquals() {
        assertEquals("This should return true", true, adb.equals(adb));
    }

}