public class P176 {
    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Queue<Integer> q = hooks.buildQueue(new Integer[]{18,5,30,5,5,3,6,6});
        System.out.println(q);
        Q3(q);
        System.out.println(q);

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
        Queue<Integer> fixed = new Queue<>();
        while(!q.isEmpty()){
            int x = q.remove();
            if(!hooks.exist(fixed, x)) fixed.insert(x);
        }
        while(!fixed.isEmpty()) q.insert(fixed.remove());
    }


}
