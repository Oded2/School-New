public class BuildNode {
    public <T> Node<T> fromArray(T[] arr) {
        Node<T> result = new Node<>(null);
        Node<T> pointer = result;
        for (T i : arr) {
            pointer.setNext(new Node<>(i));
            pointer = pointer.getNext();
        }
        return result;
    }
}
