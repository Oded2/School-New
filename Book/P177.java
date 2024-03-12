public class P177 {
    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Queue<Integer> q1 = hooks.buildQueue(new Integer[]{1, 2, 3});
        System.out.println(q1);
        System.out.println(Q7(q1));
    }

    public static boolean Q5(Queue<Integer> q, int n) {
        for (int i = 1; i <= n; i++) {
            int counter = 0;
            Queue<Integer> clone = hooks.clone(q);
            while (!clone.isEmpty()) if (clone.remove() == i) counter++;
            if (counter != i) return false;
        }
        return true;
    }

    public static boolean Q6(Queue<String> q, int n) {
        for (int i = 0; i < n; i++) q.insert(q.remove());
        return q.head().equals("gold");
    }

    public static Queue<Integer> Q7(Queue<Integer> q) {
        Queue<Integer> clone = hooks.clone(q);
        Queue<Integer> result = new Queue<>();
        result.insert(clone.remove());
        while (!clone.isEmpty()) {
            int temp = clone.remove();
            Queue<Integer> storage = new Queue<>();
            storage.insert(temp);
            System.out.println("result = " + result);
            while (hooks.getLast(result) < temp) storage.insert(hooks.removeLast(result));
            while (!storage.isEmpty()) result.insert(storage.remove());
        }
        return result;
    }
}
