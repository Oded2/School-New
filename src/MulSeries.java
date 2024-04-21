public class MulSeries {
    private double a1;
    private double q;

    public MulSeries(double a1, double q) {
        this.a1 = a1;
        this.q = q;
    }

    public Node<Double> getSeries(int length) {
        Node<Double> result = new Node<>(a1);
        Node<Double> pointer = result;
        for (int i = 1; i < length; i++) {
            pointer.setNext(new Node<>(pointer.getValue() * q));
            pointer = pointer.getNext();
        }
        return result;
    }

    public double getA(int n) {
        return a1 * Math.pow(q, n - 1);
    }

    public double getSum(int n) {
        return (a1 * (Math.pow(q, n) - 1)) / (q - 1);
    }

    public double getInfiniteSum() {
        return a1 / (1 - q);
    }

    public MulSeries oddOnly(){
        return new MulSeries(a1, Math.pow(q,2));
    }

    public MulSeries evenOnly(){
        return new MulSeries(getA(2), Math.pow(q,2));
    }

    public double getA1() {
        return a1;
    }

    public double getQ() {
        return q;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public boolean equals(MulSeries mulSeries){
        return a1 == mulSeries.getA1() && q == mulSeries.getQ();
    }

    @Override
    public String toString() {
        return getSeries(5).toString();
    }
}
