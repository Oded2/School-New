public class P178 {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Queue<Integer> open = hooks.buildQueue(1,7);
        Queue<Integer> closed = hooks.buildQueue(6,9);
        Q9(open, closed);
        System.out.println(open);
    }
    public static <T> void Q9(Queue<T> open, Queue<T> closed){
        Queue<T> storage = new Queue<>();
        while(!open.isEmpty() && !closed.isEmpty()){
            storage.insert(open.remove());
            storage.insert(closed.remove());
        }
        hooks.spill(storage, open);
        hooks.spill(storage, closed);
        hooks.spill(open, storage);
    }
    public static void Q10(Queue<Integer> q1, Queue<Integer> q2) {
        hooks.spill(q1, q2);
    }

}
