public class BuildQueue {
    public <T> Queue<T> fromArray(T[] arr) {
        Queue<T> result = new Queue<>();
        for (T i : arr) result.insert(i);
        return result;
    }
}
