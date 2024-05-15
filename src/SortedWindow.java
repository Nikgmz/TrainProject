import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortedWindow extends JFrame {
    public SortedWindow(String start, String finish) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new WrapLayout());
        setSize(700, 500);
        setTitle("Available Routes");
        setVisible(true);
        
        File file = new File("schedule.txt");
        ArrayList<Train> trains = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){
                String cityStart = scanner.next();
                String cityFinish = scanner.next();
                String timeStart = scanner.next();
                String timeFinish = scanner.next();
                String trainType = scanner.next();
                String price = scanner.next();
                Train temp = new Train(cityStart, cityFinish, timeStart, timeFinish, trainType, price);
                trains.add(temp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> fitting = new ArrayList<>();
        for (Train train : trains) {
            if (train.getStartCity().equals(start) &&
                    train.getfinishCity().equals(finish)) {
                fitting.add(train.toString());
            }
        }

        if(!fitting.isEmpty()){
            for (String s : fitting) {
                JLabel suitable = new JLabel();
                suitable.setText(s);
                add(suitable);
            }
            JButton exit = new JButton("Exit");
            exit.addActionListener(e -> dispose());
            add(exit);
        }
        else {
            JButton wrong = new JButton("No available routes with set coordinates!");
            wrong.addActionListener(e -> dispose());
            add(wrong);
        }

        pack();
    }
}
