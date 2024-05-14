import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {


    public WindowMain() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Train Service App");
        JButton goToSearch = new JButton("Go and search for routes!");
        goToSearch.addActionListener(e -> {
            SearchWindow searchWindow = new SearchWindow();
            dispose();
        });
        add(goToSearch);
        JButton goApplyJob = new JButton("Go and apply for a job!");
        JButton goSeeInfo = new JButton("Go and learn about our organisation!");
        setVisible(true);
        //pack();
    }
}
