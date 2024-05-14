public class Train {
    private final String startCity;
    private final String finishCity;
    private double startTime;
    private double arriveTime;
    private String trainType;
    private double price;


    public Train(String startCity, String finishCity, String startTime, String arriveTime, String trainType, String price) {
        this.startCity = startCity;
        this.finishCity = finishCity;
        this.startTime = ((int) startTime.charAt(0)) - 48;
        this.startTime += (double)(((int) startTime.charAt(2)) - 48 + ((int) startTime.charAt(3)) - 48)/60;
        this.arriveTime = ((int) arriveTime.charAt(0)) - 48;
        this.arriveTime += (double)(((int) arriveTime.charAt(2)) - 48 + ((int) arriveTime.charAt(3)) - 48)/60;
        this.trainType = trainType;
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while(price.charAt(i)!='$'){
            temp.append(price.charAt(i));
            ++i;
        }
        this.price = Integer.parseInt(temp.toString());
    }


    public String getStartCity() {
        return startCity;
    }

    public String getfinishCity() {
        return finishCity;
    }
}