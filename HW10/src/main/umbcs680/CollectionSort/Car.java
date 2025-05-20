package umbcs680.CollectionSort;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String model, int mileage, int year, int price) {
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
        this.dominationCount = 0;
    }

    public int getMileage() { return mileage; }
    public int getYear() { return year; }
    public int getPrice() { return price; }
    public String getModel() { return model;}

    public int getDominationCount() { return dominationCount; }
    public void setDominationCount(List<Car> cars) {
        int count = 0;
        for (Car otherCar : cars) {
            if (this == otherCar) continue;


            boolean dominates =
                    otherCar.getPrice() <= this.price &&
                            otherCar.getMileage() <= this.mileage &&
                            otherCar.getYear() >= this.year &&
                            (
                                    otherCar.getPrice() < this.price ||
                                            otherCar.getMileage() < this.mileage ||
                                            otherCar.getYear() > this.year
                            );

            if (dominates) {
                count++;
            }
        }
        this.dominationCount = count;
    }


}

