import java.util.Arrays;

public class Hooks {

    public final String[] names = {"Luke", "Anakin", "Kylo", "Lando", "Yoda"};

    public String getName() {
        return names[random(0, names.length - 1)];
    }

    public int random(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public char random(char min, char max) {
        return (char) random((int) min, max);
    }

    public Queue<Integer> clone(Queue<Integer> q) {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        while (!q.isEmpty()) {
            int x = q.remove();
            q1.insert(x);
            q2.insert(x);
        }
        while (!q1.isEmpty()) q.insert(q1.remove());
        return q2;
    }

    public boolean exist(Queue<Integer> q, int x) {
        Queue<Integer> clone = clone(q);
        while (!clone.isEmpty()) if (clone.remove().equals(x)) return true;
        return false;
    }

    public int size(Queue<Integer> q) {
        int len = 0;
        Queue<Integer> clone = clone(q);
        while (!clone.isEmpty()) {
            len++;
            clone.remove();
        }
        return len;
    }

    public boolean equals(Queue<Integer> q1, Queue<Integer> q2) {
        if (size(q1) != size(q2)) return false;
        Queue<Integer> clone1 = clone(q1);
        Queue<Integer> clone2 = clone(q2);
        while (!clone1.isEmpty()) if (clone1.remove() != clone2.remove()) return false;
        return true;
    }

    public int getLast(Queue<Integer> q) {
        Queue<Integer> clone = clone(q);
        int last = clone.remove();
        while (!clone.isEmpty()) last = clone.remove();
        return last;
    }

    public int max(Queue<Integer> q) {
        Queue<Integer> clone = clone(q);
        int max = q.head();
        while (!clone.isEmpty()) {
            int temp = clone.remove();
            if (temp > max) max = temp;
        }
        return max;
    }

    public int min(Queue<Integer> q) {
        Queue<Integer> clone = clone(q);
        int min = q.head();
        while (!clone.isEmpty()) {
            int temp = clone.remove();
            if (temp < min) min = temp;
        }
        return min;
    }


    public boolean isPalindrome(Queue<Integer> q) {
        Queue<Integer> clone = clone(q);
        while (!clone.isEmpty()) {
            int temp = clone.remove();
            if (clone.isEmpty()) return true;
            if (temp != removeLast(clone)) return false;
        }
        return true;
    }

    public int removeLast(Queue<Integer> q) {
        Queue<Integer> result = new Queue<>();
        int last = q.remove();
        while (!q.isEmpty()) {
            result.insert(last);
            last = q.remove();
        }
        while (!result.isEmpty()) q.insert(result.remove());
        return last;
    }

    public void reverse(Queue<Integer> q) {
        Queue<Integer> clone = clone(q);
        while (!q.isEmpty()) q.remove();
        while (!clone.isEmpty()) q.insert(removeLast(clone));
    }

    public void sortNull(Queue<Integer> q) {
        Queue<Integer> sorted = new Queue<>();
        while (!q.isEmpty()) {
            int min = min(q);
            q.insert(null);
            while (q.head() != null) {
                int temp = q.remove();
                if (temp == min) sorted.insert(min);
                else q.insert(temp);
            }
            q.remove();
        }
        while (!sorted.isEmpty()) q.insert(sorted.remove());
    }

    public void sort(Queue<Integer> q) {
        Queue<Integer> sorted = new Queue<>();
        while (!q.isEmpty()) {
            int min = min(q);
            sorted.insert(min);
            Queue<Integer> storage = new Queue<>();
            boolean reached = false;
            while (!q.isEmpty()) {
                int current = q.remove();
                if (current != min || reached) storage.insert(current);
                else reached = true;
            }
            while (!storage.isEmpty()) q.insert(storage.remove());
        }
        while (!sorted.isEmpty()) q.insert(sorted.remove());
    }

    public void sort(Node<Integer> node) {
        Node<Integer> pos1 = node;
        while (pos1 != null) {
            Node<Integer> pos2 = node;
            while (pos2.getNext() != null) {
                if (pos2.getValue() > pos2.getNext().getValue()) {
                    int temp = pos2.getValue();
                    pos2.setValue(pos2.getNext().getValue());
                    pos2.getNext().setValue(temp);
                }
                pos2 = pos2.getNext();
            }
            pos1 = pos1.getNext();
        }
    }

    public void reverse(Node<Integer> node) {
        Node<Integer> clone = clone(node);
        Node<Integer> pos = node;
        int first = node.getValue();
        while (pos != null) {
            Integer temp = pos.getValue();
            pos.setValue(getLast(clone).getValue());
            getLast(pos).setValue(temp);
            if (clone.getNext() != null) removeLast(clone);
            pos = pos.getNext();
        }
        getLast(node).setValue(first);
    }

    public void swap(Node<Integer> node1, Node<Integer> node2) {
        int tempVal = node1.getValue();
        Node<Integer> tempNext = node1.getNext();
        node1.setValue(node2.getValue());
        node1.setNext(node2.getNext());
        node2.setValue(tempVal);
        node2.setNext(tempNext);
    }

    public int min(Node<Integer> node) {
        int min = node.getValue();
        Node<Integer> pos = node.getNext();
        while (pos != null) {
            int temp = pos.getValue();
            if (temp < min) min = temp;
            pos = pos.getNext();
        }
        return min;
    }

    public int max(Node<Integer> node) {
        int max = node.getValue();
        Node<Integer> pos = node.getNext();
        while (pos != null) {
            int temp = pos.getValue();
            if (temp > max) max = temp;
            pos = pos.getNext();
        }
        return max;
    }

    public Node<Integer> clone(Node<Integer> node) {
        Node<Integer> pos = node.getNext();
        Node<Integer> result = new Node<>(node.getValue());
        Node<Integer> pointer = result;
        while (pos != null) {
            pointer.setNext(new Node<>(pos.getValue()));
            pointer = pointer.getNext();
            pos = pos.getNext();
        }
        return result;
    }

    public boolean exist(Node<Integer> node, int x) {
        Node<Integer> pos = node;
        while (pos != null) {
            if (pos.getValue() == x) return true;
            pos = pos.getNext();
        }
        return false;
    }

    public boolean equals(Node<Integer> node1, Node<Integer> node2) {
        Node<Integer> pos1 = node1;
        Node<Integer> pos2 = node2;
        while (pos1 != null) {
            if (pos2 == null) return false;
            if (!pos1.getValue().equals(pos2.getValue())) return false;
            pos1 = pos1.getNext();
            pos2 = pos2.getNext();
        }
        return pos2 == null;
    }

    public boolean isPalindrome(Node<Integer> node) {
        Node<Integer> clone = clone(node);
        while (clone != null) {
            if (!clone.getValue().equals(getLast(clone).getValue())) return false;
            removeLast(clone);
            clone = clone.getNext();
            if (clone != null && clone.getNext() == null) return true;
        }
        return true;
    }


    public int size(Node<Integer> node) {
        if (node == null) return 0;
        return size(node.getNext()) + 1;
    }

    public Node<Integer> getLast(Node<Integer> node) {
        Node<Integer> pos = node;
        while (pos.getNext() != null) pos = pos.getNext();
        return pos;
    }

    public void removeLast(Node<Integer> node) {
        Node<Integer> pos = node;
        while (pos.getNext().getNext() != null) pos = pos.getNext();
        pos.setNext(null);
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


    public boolean exist(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == x) return true;
        return false;
    }


    public int count(int[] arr, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] == val) count++;
        return count;
    }

    public boolean isPalindrome(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) if (arr[i] != arr[length - i - 1]) return false;
        return true;
    }

    public boolean equals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) if (arr1[i] != arr2[i]) return false;
        return true;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public <T extends Comparable<T>> void sort(T[] arr) {
        Arrays.sort(arr);
    }

    public int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current > max) max = current;
        }
        return max;
    }

    public int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current < min) min = current;
        }
        return min;
    }

    public void reverse(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) swap(arr, i, length - 1 - i);
    }

    public int firstDigit(int n) {
        while (n >= 10) n /= 10;
        return n;
    }

    public boolean exist(int num, int digit) {
        for (int i = 1; i <= num; i *= 10) if ((num % (i * 10) / i) == digit) return true;
        return false;
    }

    public int minDigit(int num) {
        int min = num % 10;
        for (int i = 1; i <= num; i *= 10) {
            int current = (num % (i * 10) / i);
            if (current < min) min = current;
        }
        return min;
    }

    public int maxDigit(int num) {
        int max = num % 10;
        for (int i = 1; i <= num; i *= 10) {
            int current = (num % (i * 10) / i);
            if (current > max) max = current;
        }
        return max;
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

    public void printArr(double[] arr) {
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

    public int[] buildArray(int min, int max) {
        int length = max - min + 1;
        int[] result = new int[length];
        for (int i = min; i <= max; i++) result[length - (max - i) - 1] = i;
        return result;
    }

    public char[] buildArray(char min, char max) {
        int length = max - min + 1;
        char[] result = new char[length];
        for (char i = min; i <= max; i++) result[length - (max - i) - 1] = i;
        return result;
    }
}