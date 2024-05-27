package job;

import main.WindowMain;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JobFinishWindow extends JFrame {
    public JobFinishWindow(String name, double years, double yearsExp) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //setSize(500, 500);
        setVisible(true);
        setTitle("Finish");
        JTextArea congrats = new JTextArea("Congratulations! You have successfully applied for the job!");
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> dispose());
        JButton openAll = new JButton("Open a list of all passing candidates");
        openAll.addActionListener(e -> {
            if(yearsExp>=5 && years >=16){//prowerqwa dali choweka e podhodqssht za rabota
                Candidate candidate = new Candidate(name, years, yearsExp);
                File sorted = new File("sorted.txt");
                try {
                    FileWriter fw = new FileWriter(sorted,true); //true oznachawa che dannite shte se zalepwat
                    fw.write(candidate.toString());
                    fw.write("\n");
                    fw.close();
                } catch (IOException t){
                    throw new RuntimeException(t);
                }
                PassingWindow passingWindow = new PassingWindow();
                dispose();
            }
        });
        add(congrats);
        JButton returnBtn = new JButton("Return");
        returnBtn.addActionListener(e -> {
            main.WindowMain windowMain = new WindowMain();
            dispose();
        });
        add(returnBtn);
        add(openAll);
        add(exit);
        pack();
    }
}
