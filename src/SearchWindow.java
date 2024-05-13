import javax.swing.*;
import java.awt.*;

public class SearchWindow extends JFrame {
    public SearchWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Search for Routes");
        JLabel start = new JLabel("From:");
        JLabel finish = new JLabel("To:");
        JComboBox<> cityStart = new JComboBox();
        JComboBox<> cityFinish = new JComboBox();
        //get the combo box info and the corresponding enter buttons
        //and get the sorted list out
    }
}
