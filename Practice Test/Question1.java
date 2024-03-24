class Question1 {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        boolean a = followers(201);
        System.out.println("a = " + a);
    }

    public static boolean followers(int num) {
        int[] count = new int[10];
        int copy = num;
        for (int i = 1; i <= num; i *= 10) {
            int current = copy % 10;
            if (count[current] > 0) return false;
            count[current] = current;
            copy /= 10;
        }
        boolean preZero = false;
        boolean postZero = false;
        for (int i : count) {
            if (preZero && i == 0) postZero = true;
            if (!postZero && i != 0) preZero = true;
            if (postZero && i != 0) return false;
        }
        return true;
    }
}
