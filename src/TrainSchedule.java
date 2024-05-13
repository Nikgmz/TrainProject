import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrainSchedule extends JFrame {
    public TrainSchedule(String type) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Schedule");

        String type1 = type.toLowerCase() + ".txt";
        File schedule = new File(type1);
        try (Scanner scanner = new Scanner(schedule)) {

        } catch (FileNotFoundException e) {
            System.out.println("Invalid file name");
        }
    }
}
