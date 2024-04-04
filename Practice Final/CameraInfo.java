public class CameraInfo {
    private int city; // Between 1-99 (included)
    private int maxSpeed;
    private CarInfo[] cars;

    public boolean allGood() {
        for (CarInfo i : cars) if (i.illegal(maxSpeed)) return false;
        return true;
    }

    public int getCity() {
        return city;
    }
}
