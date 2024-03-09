public class P177 {
    public static Hooks hooks = new Hooks();

    public static void main(String[] args) {
    }

    public static boolean Q5(Queue<Integer> q, int n) {
        int counter = 0;
        Queue<Integer> clone = hooks.clone(q);
        while (!clone.isEmpty()) if (clone.remove() == n) counter++;
        return counter == n;
    }

    public static boolean Q6(Queue<String> q, int n) {
        for (int i = 0; i < n; i++) q.insert(q.remove());
        return q.head().equals("gold");
    }
}
