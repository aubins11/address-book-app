import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {

    private AddressBook model;
    private AddressBookView view;

    public AddressBookController(AddressBook model, AddressBookView view) {
        this.model = model;
        this.view = view;
        this.view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Add Contact")) {
            String credentials = JOptionPane.showInputDialog("Enter Name and PhoneNumber (Separate with comman)");
            BuddyInfo bud = new BuddyInfo(credentials.split(",")[0], credentials.split(",")[1]);
            model.addBuddy(bud);
            System.out.println(model.toString());
        }
        if(e.getActionCommand().equals("Remove Contact")) {
            String credentials = JOptionPane.showInputDialog("Enter contact index");
            int index = Integer.parseInt(credentials);
            model.remove(index);
            System.out.println(model.toString());
        }
    }
}
