import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AddressBookView extends JFrame {

    private JFrame adbFrame;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenu addBuddyInfo;
    private JMenu removeBuddyInfo;
    private JMenuBar menubar;
    private JList<BuddyInfo> adbList;
    private JMenu createAdb;
    private AddressBook model = new AddressBook();


    public AddressBookView(JMenuBar jMenuBar, JList jList, JMenuItem jMenuItem1, JMenuItem jMenuItem2, JMenu addBuddyInfo, JMenu removeBuddyInfo) {
        this.item1 = jMenuItem1;
        this.item2 = jMenuItem2;
        this.menubar = jMenuBar;
        this.adbList = jList;
        this.addBuddyInfo = addBuddyInfo;
        this.removeBuddyInfo = removeBuddyInfo;
        this.init();
    }
    public AddressBookView(){
        init();
    }

    public void init() {
        this.adbFrame = new JFrame("AddressBook");
        this.adbFrame.setSize(500, 400);

        this.adbList = new JList<>(model);

        this.menubar = new JMenuBar();

        this.addBuddyInfo = new JMenu("Add Contact");
        this.menubar.add(addBuddyInfo);

        this.item1 = new JMenuItem("Add a new Contact");
        this.addBuddyInfo.add(item1);

        this.removeBuddyInfo = new JMenu("Remove Contact");
        this.menubar.add(removeBuddyInfo);

        this.item2 = new JMenuItem("Remove Existing Contact");
        this.removeBuddyInfo.add(item1);

        this.adbFrame.setJMenuBar(menubar);
        this.adbFrame.add(adbList);
        this.adbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.adbFrame.setVisible(true);
    }

    public void addListener(AddressBookController controller) {
        this.item1.addActionListener(controller);
        this.item2.addActionListener(controller);
    }

}
