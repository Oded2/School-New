public class P181 {
    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Queue<Integer> q = hooks.buildQueue(new Integer[]{1,2});
        System.out.println("q = " + q);
        System.out.println("buildMissing(q) = " + buildMissing(q));
    }

    public static Queue<Node<Integer>> Q15(Queue<Queue<Integer>> q) {
        Queue<Node<Integer>> qL = new Queue<>();
        while (q.isEmpty()) qL.insert(buildMissing(q.remove()));
        return qL;
    }

    public static Node<Integer> buildMissing(Queue<Integer> q) {
        Node<Integer> result = new Node<>(null);
        int first = q.remove();
        while (!q.isEmpty()) {
            int second = q.head();
            for (int i = 1; first + i < second; i++) {
                int plus = first + i;
                if (plus != second) hooks.getLast(result).setNext(new Node<>(plus));
            }
            first = q.remove();
        }
        return result.getNext();
    }
}
