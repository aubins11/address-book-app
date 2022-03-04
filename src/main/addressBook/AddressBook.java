import javax.persistence.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * @author aubin musingya
 */
@Entity
public class AddressBook extends DefaultListModel<BuddyInfo>{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private ArrayList<BuddyInfo> buddyInfos;

    /**
     *
     */
    public AddressBook() {
        this.buddyInfos = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public ArrayList<BuddyInfo> getBuddyInfos() {
        return this.buddyInfos;
    }

    public void setBuddyInfos(ArrayList<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    /**
     *
     * @param buddy
     */
    public void addBuddy(BuddyInfo buddy) {
        if(buddy != null) {
            this.buddyInfos.add(buddy);
            super.addElement(buddy);
        }
    }

    /**
     *
     * @param index
     */
    public BuddyInfo removeBuddy(int index) {
        if (index >= 0 && index < this.buddyInfos.size()) {
            super.removeElementAt(index);
            return this.buddyInfos.remove(index);
        }
        return null;
    }

    public int size() {
        return buddyInfos.size();
    }

    public void clear() {
        buddyInfos.clear();
    }

    public boolean contains(BuddyInfo bud) {
        return buddyInfos.contains(bud);
    }

    /**
     *
     */
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
        AddressBook bud = (AddressBook) o;
        return (this == bud);
    }
}
