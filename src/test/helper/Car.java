package test.helper;

public class Car implements Comparable<Car> {

    private String brand;
    private int prodYear;

    public Car(String brand, int prodYear) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public int compareTo(Car car) {
        if (this.brand.compareTo(car.getBrand()) > 0)
            return 1;
        else if (this.brand.compareTo(car.getBrand()) == 0)
            return 0;
        else
            return -1;
    }
}
