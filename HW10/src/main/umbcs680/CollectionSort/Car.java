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

        for (Car other : cars) {
            if (this == other) continue;

            int betterOrEqual = 0;
            int strictlyBetter = 0;


            if (other.getPrice() <= this.getPrice()) {
                betterOrEqual++;
                if (other.getPrice() < this.getPrice()) {
                    strictlyBetter++;
                }
            }


            if (other.getMileage() <= this.getMileage()) {
                betterOrEqual++;
                if (other.getMileage() < this.getMileage()) {
                    strictlyBetter++;
                }
            }


            if (other.getYear() >= this.getYear()) {
                betterOrEqual++;
                if (other.getYear() > this.getYear()) {
                    strictlyBetter++;
                }
            }


            if (betterOrEqual == 3 && strictlyBetter >= 1) {
                count++;
            }
        }

        this.dominationCount = count;
    }



}

