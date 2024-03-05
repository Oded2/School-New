public class P176 {

    public static final BuildQueue buildQueue = new BuildQueue();
    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 2};
        Queue<Integer> q1 = buildQueue.fromArray(arr1);
        Queue<Integer> q2 = buildQueue.fromArray(arr2);
        System.out.println("q1 = " + q1);
        System.out.println("q2 = " + q2);
        System.out.println(q1 == q2);
        System.out.println(Q2(q1, q2));

    }

    public static boolean Q1(Queue<Integer> q, int n) {
        Queue<Integer> q1 = hooks.clone(q);
        boolean streak = false;
        while (!q1.isEmpty()) {
            if (streak && q1.head() == n) return true;
            streak = q1.remove() == n;
        }
        return false;
    }

    public static boolean Q2(Queue<Integer> q1, Queue<Integer> q2) {
        return hooks.equals(q1, q2);
    }

    public static void Q3(Queue<Integer> q) {
        Node<Integer> list = new Node<>(null);
        Node<Integer> pointer = list;
        q.insert(null);
        while (q.head() != null) {
            int current = q.remove();
            if (!hooks.exist(list, current)) q.insert(current);
            pointer.setNext(new Node<>(current));
            pointer = pointer.getNext();
        }
        q.remove();
    }


}
