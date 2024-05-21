package job;

import main.WindowMain;

import javax.swing.*;
import java.awt.*;

public class JobFinishWindow extends JFrame {
    public JobFinishWindow(String name, int years, int yearsExp) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setTitle("Finish");
        JTextArea congrats = new JTextArea("Congratulations! You have successfully applied for the job!");
        JTextArea toDo = new JTextArea("Now you can:");
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> dispose());
        JButton openAll = new JButton("Open a list of all passing candidates:");
        openAll.addActionListener(e -> {
            if(yearsExp>=5){
                Candidate candidate = new Candidate(name, years, yearsExp);
                PassingWindow passingWindow = new PassingWindow(candidate);
            }
        });
        add(congrats);
        add(toDo);
        JButton returnBtn = new JButton("Return");
        returnBtn.addActionListener(e -> {
            main.WindowMain windowMain = new WindowMain();
            dispose();
        });
        add(returnBtn);
        add(openAll);
        add(exit);
    }
}
