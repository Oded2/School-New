import java.util.Arrays;

public class Hooks {
    private final String[] names = {"Luke", "Anakin", "Kylo", "Obi Wan", "Lando", "Mando", "Yoda", "Mace Windu"};

    public int random(int min, int max) {
        return (int) Math.round(random((double) min, max));
    }

    public double random(double min, double max) {
        return (double) Math.round((Math.random() * (max - min) + min) * 100) / 100;
    }

    public <T> Queue<T> clone(Queue<T> q) {
        Queue<T> q1 = new Queue<>();
        Queue<T> q2 = new Queue<>();
        while (!q.isEmpty()) {
            T x = q.remove();
            q1.insert(x);
            q2.insert(x);
        }
        while (!q1.isEmpty()) q.insert(q1.remove());
        return q2;
    }

    public <T> boolean exist(Queue<T> q, T x) {
        Queue<T> q1 = clone(q);
        while (!q1.isEmpty()) if (q1.remove() == x) return true;
        return false;
    }

    public <T> int length(Queue<T> q) {
        int len = 0;
        Queue<T> clone = clone(q);
        while (!clone.isEmpty()) {
            len++;
            clone.remove();
        }
        return len;
    }

    public <T> boolean equals(Queue<T> q1, Queue<T> q2) {
        if (length(q1) != length(q2)) return false;
        Queue<T> clone1 = clone(q1);
        Queue<T> clone2 = clone(q2);
        while (!clone1.isEmpty()) if (clone1.remove() != clone2.remove()) return false;
        return true;
    }

    public <T> T getLast(Queue<T> q) {
        Queue<T> clone = clone(q);
        T last = clone.head();
        while (!clone.isEmpty()) last = clone.remove();
        return last;
    }

    public <T extends Comparable<T>> T max(Queue<T> q) {
        Queue<T> clone = clone(q);
        T max = clone.head();
        while (!clone.isEmpty()) {
            T current = clone.remove();
            if (current.compareTo(max) > 0) max = current;
        }
        return max;
    }

    public <T extends Comparable<T>> T min(Queue<T> q) {
        Queue<T> clone = clone(q);
        T min = clone.head();
        while (!clone.isEmpty()) {
            T current = clone.remove();
            if (current.compareTo(min) < 0) min = current;
        }
        return min;
    }

    public <T> boolean exist(Node<T> node, T x) {
        Node<T> pos = node;
        while (pos != null) {
            if (pos.getValue() == x) return true;
            pos = pos.getNext();
        }
        return false;
    }

    public <T> boolean exist(T[] arr, T x) {
        for (T i : arr) if (i == x) return true;
        return false;
    }

    public <T> void printArr(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public <T> Queue<T> buildQueue(T[] arr) {
        Queue<T> result = new Queue<>();
        for (T i : arr) result.insert(i);
        return result;
    }

    public Queue<Integer> buildQueue(int min, int max) {
        Queue<Integer> result = new Queue<>();
        for (int i = min; i <= max; i++) result.insert(i);
        return result;
    }


    public Queue<Integer> buildQueue(int min, int max, int length) {
        Queue<Integer> result = new Queue<>();
        for (int i = 0; i < length; i++) result.insert(random(min, max));
        return result;
    }

    public <T> Node<T> buildNode(T[] arr) {
        Node<T> result = new Node<>(null);
        Node<T> pointer = result;
        for (T i : arr) {
            pointer.setNext(new Node<>(i));
            pointer = pointer.getNext();
        }
        return result.getNext();
    }
}