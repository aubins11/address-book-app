import javax.persistence.*;
import java.util.Random;

/**
 * @author aubin musingya
 */
@Entity(name="BuddyInfo")
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phoneNumber;

    public BuddyInfo() {

    }

    /**
     *
     * @param name
     * @param phoneNumber
     */
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }


    public void setId(Integer id) {
        this.id = id;
    }

    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BuddyInfo [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    /**
     *
     */
    @Override
    public boolean equals(Object o) {

        if(o == this) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(this.getClass() != o.getClass()) {
            return false;
        }
        BuddyInfo bud = (BuddyInfo) o;
        return (this == bud);
    }
}
