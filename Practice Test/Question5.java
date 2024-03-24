public class Question5 {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Integer[] arr1 = {3, 12, 30, 42};
        Integer[] arr2 = {10, 20, 35, 50};
        Queue<Integer> q1 = hooks.buildQueue(arr1);
        Queue<Integer> q2 = hooks.buildQueue(arr2);
        System.out.println("q1 = " + q1);
        System.out.println("q2 = " + q2);
        System.out.println(interlocked(q1, q2, 3));
    }

    public static boolean interlocked(Queue<Integer> q1, Queue<Integer> q2, int n) {
        while (!q1.isEmpty()) {
            int temp1 = q1.remove();
            int temp2 = q2.remove();
            for (int i = 1; i < n; i++) temp1 = q1.remove();
            for (int i = 1; i < n; i++) temp2 = q2.remove();
            if (temp1 > temp2) return false;
        }
        return true;
//        while (!q1.isEmpty()) if (q1.remove() > q2.remove()) return false;
//        return true;
    }

}
