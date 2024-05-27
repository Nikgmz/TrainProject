package job;

import main.WindowMain;

import javax.swing.*;
import java.awt.*;

public class JobApplication extends JFrame {
    public JobApplication() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setTitle("Job Application");

        JLabel fullNameLbl = new JLabel("Full Name: ");//poleta za wuwezhdane na danni
        JTextArea fullNameTxtA = new JTextArea();
        fullNameTxtA.setEditable(true);//mozhe da se pishe w tqh
        fullNameTxtA.setColumns(10);
        JLabel yearsLbl = new JLabel("Age: ");
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

        JButton enter = new JButton("Enter");//butoni enter, return i openAll
        enter.addActionListener(e->{
            double yearsExp = Double.parseDouble(yearsExpTxtA.getText());
            String name = fullNameTxtA.getText();
            double years = Double.parseDouble(yearsTxtA.getText());
            JobFinishWindow jobFinishWindow = new JobFinishWindow(name, years, yearsExp);
            dispose();
        });
        add(enter);
        JButton returnBtn = new JButton("Return");
        returnBtn.addActionListener(e -> {
            main.WindowMain windowMain = new WindowMain();
            dispose();
        });

        add(returnBtn);
        JButton openAll = new JButton("Open a list of all passing candidates");
        openAll.addActionListener(e -> {
            PassingWindow passingWindow = new PassingWindow();
            dispose();
        });
        add(openAll);
        pack();//smestwa wsichkite elementi
    }
}
