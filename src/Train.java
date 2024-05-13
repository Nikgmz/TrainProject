import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Train {
    private String startCity;
    private String arriveCity;
    private double startTime;
    private double arriveTime;
    private String trainType;
    private double price;

    public Train(String startCity, String arriveCity, String startTime, String arriveTime, String trainType, String price) {
        this.startTime = ((int) startTime.charAt(0)) - 48;
        this.startTime += (double)(((int) startTime.charAt(2)) - 48 + ((int) startTime.charAt(3)) - 48)/60;
        this.arriveTime = ((int) arriveTime.charAt(0)) - 48;
        this.arriveTime += (double)(((int) arriveTime.charAt(2)) - 48 + ((int) arriveTime.charAt(3)) - 48)/60;
        this.trainType = trainType;
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while(price.charAt(i)!='.'){
            temp.append(price.charAt(i));
            ++i;
        }
        this.price = Integer.parseInt(temp.toString());
    }
    public ArrayList<String> getNamesStart(){
        File file = new File("schedules.txt");
        Scanner scanner;
        try (Scanner scanner1 = scanner = new Scanner(file)) {
            ArrayList<Train> trains = new ArrayList<>();
            while(scanner.hasNext()){
                //get all the values into the array
            }
            //get all the different possible cities into an arraylist
            //and return it

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}