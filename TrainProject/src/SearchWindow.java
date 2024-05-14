import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SearchWindow extends JFrame {
    public SearchWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setTitle("Search for Routes");
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

        JLabel start = new JLabel("From:");
        JLabel finish = new JLabel("To:");
        JComboBox<String> cityStart = new JComboBox<>(getNamesStart(trains));
        JComboBox<String> cityFinish = new JComboBox<>(getNamesFinish(trains));
        add(start);
        add(cityStart);
        add(finish);
        add(cityFinish);
    }

    public String[] getNamesStart(ArrayList<Train> trains){

        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < trains.size(); i++) {
            String city = trains.get(i).getStartCity();
            for (int j = i + 1; j < trains.size(); j++) {
                String compare = trains.get(j).getStartCity();
                if(!city.equals(compare)){
                    names.add(city);
                }
            }
        }
        names.sort(Comparator.naturalOrder());
        String[] answer = new String[names.size()];//transformiram Arraylist wuw String[] zashtoto JComboBox
                                                    //ne priema ArrayListi
        answer = names.toArray(answer);
        return answer;
    }
    public String[] getNamesFinish(ArrayList<Train> trains){
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < trains.size(); i++) {
            String city = trains.get(i).getfinishCity();
            for (int j = i + 1; j < trains.size(); j++) {
                String compare = trains.get(j).getfinishCity();
                if(!city.equals(compare)){
                    names.add(city);
                }
            }
        }
        names.sort(Comparator.naturalOrder());
        String[] answer = new String[names.size()];//transformiram Arraylist wuw String[] zashtoto JComboBox
        //ne priema ArrayListi
        answer = names.toArray(answer);
        return answer;
    }
}
