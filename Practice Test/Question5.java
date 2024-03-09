public class Question5 {

    public static final Hooks hooks = new Hooks();
    public static void main(String[] args) {
        Integer[] arr1 = {3,12,30,42};
        Integer[] arr2 = {10,20,27,50};
        Queue<Integer> q1 = hooks.buildQueue(arr1);
        Queue<Integer> q2 = hooks.buildQueue(arr2);
        System.out.println(interlocked(q1,q2));
    }

    public static boolean interlocked(Queue<Integer> q1, Queue<Integer> q2) {
        while (!q1.isEmpty()) if (q1.remove() > q2.remove()) return false;
        return true;
    }

}
