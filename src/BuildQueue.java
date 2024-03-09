public class BuildQueue {
    public <T> Queue<T> fromArray(T[] arr) {
        Queue<T> result = new Queue<>();
        for (T i : arr) result.insert(i);
        return result;
    }

    public Queue<Integer> ascending(int max) {
        return ascending(1, max);
    }

    public Queue<Integer> ascending(int min, int max) {
        return ascending(min, max, 1);
    }

    public Queue<Integer> ascending(int min, int max, int skip) {
        Queue<Integer> result = new Queue<>();
        for (int i = min; i <= max; i += skip) result.insert(i);
        return result;
    }
}
