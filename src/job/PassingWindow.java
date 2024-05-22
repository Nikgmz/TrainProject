package job;

import main.WindowMain;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class PassingWindow extends JFrame{
    public PassingWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setTitle("All candidates");

        File sorted = new File("sorted.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(sorted);
            while(scanner.hasNext()){
                String passing = scanner.nextLine();
                JTextArea passingTxtA = new JTextArea();
                passingTxtA.setText(passing);
                add(passingTxtA);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            assert scanner!=null;
            scanner.close();
        }


        JButton returnBtn = new JButton("Return");
        returnBtn.addActionListener(e -> {
            main.WindowMain windowMain = new WindowMain();
            dispose();
        });
        add(returnBtn);
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> dispose());
        add(exit);
    }
}
