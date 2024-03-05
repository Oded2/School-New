public class Hooks {
    private final String[] names = {"Luke", "Anakin", "Kylo", "Obi Wan", "Lando", "Mando", "Yoda", "Mace Windu"};
    
    public int random(int min, int max) {
        return (int) Math.round(this.random((double) min, max));
    }

    public double random(double min, double max) {
        return (double) Math.round((Math.random() * (max - min) + min) * 100) / 100;
    }

    public char random(char min, char max) {
        return (char) random((int) min, max);
    }
}