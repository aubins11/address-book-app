import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo buddy1 = null;

    @Before
    public void setUp() throws Exception {
        buddy1 = new BuddyInfo("Aubin", "6139154311");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        assertEquals("This should return Aubin","Aubin", buddy1.getName());
    }

    @Test
    public void setName() {
        buddy1.setName("Aubeezy");
        assertEquals("This should return Aubeezy","Aubeezy", buddy1.getName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("This should return 6139154311", "6139154311", buddy1.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        buddy1.setPhoneNumber("6139151143");
        assertEquals("This should return 6139154311", "6139151143", buddy1.getPhoneNumber());
    }

    @Test
    public void testToString() {
        assertEquals("This should return BuddyInfo [name=Aubin, phoneNumber=6139154311]", "BuddyInfo [name=Aubin, phoneNumber=6139154311]", buddy1.toString());
    }

    @Test
    public void testEquals() {
        assertEquals("This should return true", true, buddy1.equals(buddy1));
    }

    @Test
    public void performJPA() {

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Aubin");
        buddy1.setPhoneNumber("613");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Samu");
        buddy2.setPhoneNumber("343");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lab");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT buddy FROM BuddyInfo buddy");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddyInfos\n----------------");

        for (BuddyInfo buddy : results) {

            System.out.println(buddy.getName() + " (id=" + buddy.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }
}