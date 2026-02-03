package BehaviouralPatterns.Observer;

public class MobileDevice implements Observer{
    private float temp = 0f;

    public MobileDevice(){
        System.out.println("Printing initial Mobile device temp -> " + temp);
    }

    @Override
    public void update(float temp) {
        this.temp = temp;
        System.out.println("Mobile Device :: Temp -> " + temp);
    }

//    public void printCurrentTemp(){
//        System.out.println("Mobie Device :: Temp -> " + temp);
//    }

}
