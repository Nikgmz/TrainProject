public class Train {
    private final String startCity;
    private final String finishCity;
    private final String startTime;
    private final String arriveTime;
    private final String trainType;
    private final String price;


    public Train(String startCity, String finishCity, String startTime, String arriveTime, String trainType, String price) {
        this.startCity = startCity;
        this.finishCity = finishCity;
        this.startTime = startTime;
        this.arriveTime = arriveTime;
        this.trainType = trainType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Train:" +
                " Starts from: " + startCity  +
                ", Arrives in: " + finishCity +
                ", From: " + startTime +
                ", Until: " + arriveTime +
                ", Train type: " + trainType +
                ", Price: " + price;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getfinishCity() {
        return finishCity;
    }
}