public class PartTwo {

    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 1, 4, 3, 15, 9};
        Queue<Integer> q = hooks.buildQueue(arr);
        System.out.println(q);
        System.out.println(twoSum(q, 9));
    }

    //    Question 4
    public static boolean twoSum(Queue<Integer> q, int x) {
        while (!q.isEmpty()) {
            Queue<Integer> clone = hooks.clone((q));
            int current = q.remove();
            while (!clone.isEmpty()) if (current + clone.remove() == x) return true;
        }
        return false;
    }

}
