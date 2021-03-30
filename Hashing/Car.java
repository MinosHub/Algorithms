package Hashing;

public class Car {

    public String make;
    public String model;
    public String vin;
    public int oilLevel;
    public String tracker = "";


    public Car(String make, String model, String vin, int oilLevel)   // this is the main modification line to change arguments' DATA TYPE
    {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.oilLevel = oilLevel;
    }
}
