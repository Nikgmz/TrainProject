package train;

import main.WindowMain;

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
        JButton enter = new JButton("Enter");
        enter.addActionListener(e -> {
            String startSelectedItem = cityStart.getSelectedItem().toString();
            String finishSelectedItem = cityFinish.getSelectedItem().toString();
            SortedWindow sortedWindow = new SortedWindow(startSelectedItem, finishSelectedItem);
            dispose();
        });
        add(start);
        add(cityStart);
        add(finish);
        add(cityFinish);
        add(enter);
        JButton returnBtn = new JButton("Return");
        returnBtn.addActionListener(e -> {
            main.WindowMain windowMain = new WindowMain();
            dispose();
        });
        add(returnBtn);
        pack();
    }

    public String[] getNamesStart(ArrayList<Train> trains){

        ArrayList<String> names = new ArrayList<>();
        names.add("");
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
        for (int i = 0; i < names.size()-1; i++) {
            if(names.get(i).equals(names.get(i+1))){
                names.set(i, "");
            }
        }
        while(names.remove("")){

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
        for (int i = 0; i < names.size()-1; i++) {
            if(names.get(i).equals(names.get(i+1))){
                names.set(i, "");
            }
        }
        while(names.remove("")){

        }
        String[] answer = new String[names.size()];//transformiram Arraylist wuw String[] zashtoto JComboBox
        //ne priema ArrayListi
        answer = names.toArray(answer);
        return answer;
    }
}
