public class NumCount {
    private int num;
    private int count; // >=0

    public NumCount(int num) {
        this.num = num;
        this.count = 1;
    }

    public int getNum() {
        return num;
    }
    public int getCount(){
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
