public class CarInfo {
    private String id;
    private boolean privateCar;
    private int speed;
    public boolean illegal(int maxSpeed){
        return privateCar || speed > maxSpeed;
    }
}
