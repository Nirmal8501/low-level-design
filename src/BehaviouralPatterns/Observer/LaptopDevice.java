package BehaviouralPatterns.Observer;

public class LaptopDevice implements Observer{
    private float temp = 0f;

    public LaptopDevice(){
        System.out.println("Printing initial Laptop device temp -> " + temp);
    }

    @Override
    public void update(float temp) {
        this.temp = temp;
        System.out.println("Laptop Device :: Temp -> " + temp);
    }

//    public void printCurrentTemp(){
//        System.out.println("Laptop Device :: Temp -> " + temp);
//    }
}
