public class P178 {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {

    }

    public static Queue<Integer> Q10(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> clone1 = hooks.clone(q1);
        Queue<Integer> clone2 = hooks.clone(q2);
        while (!clone2.isEmpty()) clone1.insert(clone2.remove());
        return clone1;
    }

}
