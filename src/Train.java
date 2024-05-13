public class Train {
    private String startCity;
    private String arriveCity;
    private double  startTime;
    private double arriveTime;
    private String trainType;
    private int price;

    public Train(String startCity, String arriveCity, String startTime, String arriveTime, String trainType, String price) {
        this.startCity = startCity;
        this.arriveCity = arriveCity;
        this.startTime = ((int) startTime.charAt(0)) - 48;
        this.startTime += (double)(((int) startTime.charAt(2)) - 48 + ((int) startTime.charAt(3)) - 48)/60;
        this.arriveTime = (double)((int) arriveTime.charAt(0)) - 48;
        this.arriveTime += (((int) arriveTime.charAt(2)) - 48 + ((int) arriveTime.charAt(3)) - 48)/60;
        this.trainType = trainType;
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while(price.charAt(i)!='.'){
            temp.append(price.charAt(i));
            ++i;
        }
        this.price = Integer.parseInt(temp.toString());
    }

    public Train() {
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
