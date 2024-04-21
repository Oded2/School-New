public class CalcSeries {
    private double a1;
    private double d;

    public CalcSeries(double a1, double d) {
        this.a1 = a1;
        this.d = d;
    }

    public Node<Double> getSeries(int length) {
        Node<Double> result = new Node<>(a1);
        Node<Double> pointer = result;
        for (int i = 1; i < length; i++) {
            pointer.setNext(new Node<>(pointer.getValue() + d));
            pointer = pointer.getNext();
        }
        return result;
    }

    public double getA(int n) {
        return a1 + (n - 1) * d;
    }

    public double getSum(int n) {
        return (n * (a1 * 2 + (n - 1) * d)) / 2;
    }

    public double getA1() {
        return a1;
    }

    public double getD() {
        return d;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public void setD(double d) {
        this.d = d;
    }
    public boolean equals(CalcSeries calcSeries){
        return a1 == calcSeries.getA1() && d == calcSeries.getD();
    }

    @Override
    public String toString() {
        return getSeries(3).toString();
    }
}
