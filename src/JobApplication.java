import javax.swing.*;
import java.awt.*;

public class JobApplication extends JFrame {
    public JobApplication() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setTitle("Job Application");

        JLabel fullNameLbl = new JLabel("Full Name: ");
        JTextArea fullNameTxtA = new JTextArea();
        fullNameTxtA.setEditable(true);
        fullNameTxtA.setColumns(10);
        JLabel yearsLbl = new JLabel("Years: ");
        JTextArea yearsTxtA = new JTextArea();
        yearsTxtA.setEditable(true);
        yearsTxtA.setColumns(10);
        JLabel yearsExpLbl = new JLabel("Prior experience (years): ");
        JTextArea yearsExpTxtA = new JTextArea();
        yearsExpTxtA.setEditable(true);
        yearsExpTxtA.setColumns(10);

        add(fullNameLbl);
        add(fullNameTxtA);
        add(yearsLbl);
        add(yearsTxtA);
        add(yearsExpLbl);
        add(yearsExpTxtA);
        JButton enter = new JButton("Enter");
        enter.addActionListener(e->{
            int yearsExp = Integer.parseInt(yearsExpTxtA.getText());
            JobFinishWindow jobFinishWindow = new JobFinishWindow(yearsExp);
            dispose();
        });
        add(enter);
    }
}
