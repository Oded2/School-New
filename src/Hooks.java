import java.util.Arrays;

public class Hooks {

//    a.compareTo(b) returns: 1 if a > b, 0 if a == b, and -1 if a < b.

    public final String[] names = {"Luke", "Anakin", "Kylo", "Lando", "Yoda"};

    public String getName() {
        return names[random(0, names.length - 1)];
    }

    public int random(int min, int max) {
        return (int) Math.round(random((double) min, max));
    }

    public double random(double min, double max) {
        return (double) Math.round((Math.random() * (max - min) + min) * 100) / 100;
    }

    public char random(char min, char max) {
        return (char) random((int) min, max);
    }

    public <T> Queue<T> clone(Queue<T> q) {
        Queue<T> q1 = new Queue<>();
        Queue<T> q2 = new Queue<>();
        while (!q.isEmpty()) {
            T x = q.remove();
            q1.insert(x);
            q2.insert(x);
        }
        spill(q, q1);
        return q2;
    }

    public <T> boolean exist(Queue<T> q, T x) {
        Queue<T> clone = clone(q);
        while (!clone.isEmpty()) if (clone.remove().equals(x)) return true;
        return false;
    }

    public <T> int size(Queue<T> q) {
        int len = 0;
        Queue<T> clone = clone(q);
        while (!clone.isEmpty()) {
            len++;
            clone.remove();
        }
        return len;
    }

    public <T> boolean equals(Queue<T> q1, Queue<T> q2) {
        if (size(q1) != size(q2)) return false;
        Queue<T> clone1 = clone(q1);
        Queue<T> clone2 = clone(q2);
        while (!clone1.isEmpty()) if (clone1.remove() != clone2.remove()) return false;
        return true;
    }

    public <T> T getLast(Queue<T> q) {
        Queue<T> clone = clone(q);
        T last = clone.remove();
        while (!clone.isEmpty()) last = clone.remove();
        return last;
    }

    public <T extends Comparable<T>> T max(Queue<T> q) {
        Queue<T> clone = clone(q);
        T max = firstNotNull(q);
        while (!clone.isEmpty()) {
            T current = clone.remove();
            if (current != null && current.compareTo(max) > 0) max = current;
        }
        return max;
    }

    public <T extends Comparable<T>> T min(Queue<T> q) {
        Queue<T> clone = clone(q);
        T min = firstNotNull(q);
        while (!clone.isEmpty()) {
            T current = clone.remove();
            if (current != null && current.compareTo(min) < 0) min = current;
        }
        return min;
    }

    public <T> T firstNotNull(Queue<T> q) {
        Queue<T> clone = clone(q);
        T current = clone.remove();
        while (current == null) current = clone.remove();
        return current;
    }

    public <T> boolean isPalindrome(Queue<T> q) {
        Queue<T> clone = clone(q);
        while (!clone.isEmpty()) {
            T temp = clone.remove();
            if (clone.isEmpty()) return true;
            if (!temp.equals( removeLast(clone))) return false;
        }
        return true;
    }

    public <T> T removeLast(Queue<T> q) {
        Queue<T> result = new Queue<>();
        T last = q.remove();
        while (!q.isEmpty()) {
            result.insert(last);
            last = q.remove();
        }
        spill(q, result);
        return last;
    }

    public <T> void spill(Queue<T> in, Queue<T> out) {
        while (!out.isEmpty()) in.insert(out.remove());
    }

    public <T> void reverse(Queue<T> q) {
        Queue<T> clone = clone(q);
        clear(q);
        while (!clone.isEmpty()) q.insert(removeLast(clone));
    }

    public <T> void clear(Queue<T> q) {
        while (!q.isEmpty()) q.remove();
    }

    public <T extends Comparable<T>> void sort(Queue<T> q) {
        Queue<T> sorted = new Queue<>();
        while (!q.isEmpty()) {
            T max = max(q);
            sorted.insert(max);
            Queue<T> storage = new Queue<>();
            boolean reached = false;
            while (!q.isEmpty()) {
                T current = q.remove();
                if (!current.equals(max) || reached) storage.insert(current);
                else reached = true;
            }
            spill(q, storage);
        }
        spill(q, sorted);
    }

    public <T extends Comparable<T>> void sort(Node<T> node) {
        Node<T> pos1 = node;
        while (pos1 != null) {
            Node<T> pos2 = node;
            while (pos2.getNext() != null) {
                if (pos2.getValue().compareTo(pos2.getNext().getValue()) > 0) {
                    T temp = pos2.getValue();
                    pos2.setValue(pos2.getNext().getValue());
                    pos2.getNext().setValue(temp);
                }
                pos2 = pos2.getNext();
            }
            pos1 = pos1.getNext();
        }
    }

    public <T> void reverse(Node<T> node) {
        Node<T> clone = clone(node);
        Node<T> pos = node;
        T first = node.getValue();
        while (pos != null) {
            T temp = pos.getValue();
            pos.setValue(getLast(clone).getValue());
            getLast(pos).setValue(temp);
            if (clone.getNext() != null) removeLast(clone);
            pos = pos.getNext();
        }
        getLast(node).setValue(first);
    }

    public <T> void swap(Node<T> node1, Node<T> node2) {
        T tempVal = node1.getValue();
        Node<T> tempNext = node1.getNext();
        node1.setValue(node2.getValue());
        node1.setNext(node2.getNext());
        node2.setValue(tempVal);
        node2.setNext(tempNext);
    }

    public <T extends Comparable<T>> T min(Node<T> node) {
        T min = firstNotNull(node);
        Node<T> pos = node.getNext();
        while (pos != null) {
            T current = pos.getValue();
            if (min.compareTo(current) > 0) min = current;
            pos = pos.getNext();
        }
        return min;
    }

    public <T extends Comparable<T>> T max(Node<T> node) {
        T max = firstNotNull(node);
        Node<T> pos = node.getNext();
        while (pos != null) {
            T current = pos.getValue();
            if (current != null && max.compareTo(current) < 0) max = current;
            pos = pos.getNext();
        }
        return max;
    }

    public <T> T firstNotNull(Node<T> node) {
        Node<T> pos = node;
        while (pos.getValue() == null) pos = pos.getNext();
        return pos.getValue();
    }

    public <T> void clear(Node<T> node, T val) {
        node.setValue(val);
        node.setNext(null);
    }

    public <T> Node<T> clone(Node<T> node) {
        Node<T> pos = node.getNext();
        Node<T> result = new Node<>(node.getValue());
        Node<T> pointer = result;
        while (pos != null) {
            pointer.setNext(new Node<>(pos.getValue()));
            pointer = pointer.getNext();
            pos = pos.getNext();
        }
        return result;
    }

    public <T> boolean exist(Node<T> node, T x) {
        Node<T> pos = node;
        while (pos != null) {
            if (pos.getValue().equals(x)) return true;
            pos = pos.getNext();
        }
        return false;
    }

    public <T> boolean equals(Node<T> node1, Node<T> node2) {
        Node<T> pos1 = node1;
        Node<T> pos2 = node2;
        while (pos1 != null) {
            if (pos2 == null) return false;
            if (!pos1.getValue().equals(pos2.getValue())) return false;
            pos1 = pos1.getNext();
            pos2 = pos2.getNext();
        }
        return pos2 == null;
    }

    public <T> boolean isPalindrome(Node<T> node) {
        Node<T> clone = clone(node);
        while (clone != null) {
            if (!clone.getValue().equals(getLast(clone).getValue())) return false;
            removeLast(clone);
            clone = clone.getNext();
            if (clone != null && clone.getNext() == null) return true;
        }
        return true;
    }

    public <T> Node<T> getLast(Node<T> node) {
        Node<T> pos = node;
        while (pos.getNext() != null) pos = pos.getNext();
        return pos;
    }

    public <T> void removeLast(Node<T> node) {
        Node<T> pos = node;
        while (pos.getNext().getNext() != null) pos = pos.getNext();
        pos.setNext(null);
    }

    public <T> int size(Node<T> node) {
        if (node == null) return 0;
        return size(node.getNext()) + 1;
    }

    public int sum(Node<Integer> node) {
        int sum = 0;
        Node<Integer> pos = node;
        while (pos != null) {
            sum += pos.getValue();
            pos = pos.getNext();
        }
        return sum;
    }

    public <T> boolean exist(T[] arr, T x) {
        for (T i : arr) if (i.equals(x)) return true;
        return false;
    }

    public boolean exist(int[] arr, int x) {
        for (int i : arr) if (i == x) return true;
        return false;
    }

    public <T> boolean isPalindrome(T[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) if (arr[i] != arr[length - i - 1]) return false;
        return true;
    }

    public <T> boolean equals(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) if (!arr1[i].equals(arr2[i])) return false;
        return true;
    }

    public <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public <T extends Comparable<T>> void sort(T[] arr) {
        Arrays.sort(arr);
    }

    public <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            T current = arr[i];
            if (current.compareTo(max) > 0) max = current;
        }
        return max;
    }

    public <T extends Comparable<T>> T min(T[] arr) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            T current = arr[i];
            if (current.compareTo(min) < 0) min = current;
        }
        return min;
    }

    public <T> void reverse(T[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) swap(arr, i, length - 1 - i);
    }

    public <T> void printArr(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void printArr(char[] arr) {
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

    public Queue<Character> buildQueue(char min, char max, int length) {
        Queue<Character> result = new Queue<>();
        for (int i = 0; i < length; i++) result.insert(random(min, max));
        return result;
    }

    public Queue<Character> buildQueue(char start, char end) {
        Queue<Character> result = new Queue<>();
        for (char i = start; i <= end; i++) result.insert(i);
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

    public Node<Integer> buildNode(int min, int max) {
        Node<Integer> result = new Node<>(null);
        Node<Integer> pointer = result;
        for (int i = min; i <= max; i++) {
            pointer.setNext(new Node<>(i));
            pointer = pointer.getNext();
        }
        return result.getNext();
    }

    public Node<Integer> buildNode(int min, int max, int length) {
        Node<Integer> result = new Node<>(null);
        Node<Integer> pointer = result;
        for (int i = 0; i < length; i++) {
            pointer.setNext(new Node<>(random(min, max)));
            pointer = pointer.getNext();
        }
        return result.getNext();
    }
}