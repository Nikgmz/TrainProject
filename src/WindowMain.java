import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {


    public WindowMain() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Train Service App");

        JLabel categoryLabel = new JLabel("Look at schedule: ");
        String[] typeDestination = {
            "Arriving", "Leaving"
        };
        JComboBox<String> category = new JComboBox<>(typeDestination);
        JButton enter = new JButton("Enter");
        enter.addActionListener(e -> {//tuk polzwam lambda, zashtoto warningite w intellij kazaha che bi mi
                                        //optimiziralo koda, a te ne greshat
            String type = (String) category.getSelectedItem();
            assert type != null;
            new TrainSchedule(type);

        });
        add(categoryLabel);
        add(category);
        add(enter);


        JButton applyJobs;
        JButton information;


        setVisible(true);
        //pack();
    }
}
