public class Functions {
    public static final Hooks hooks = new Hooks();

    public static void main(String[] args) {
        int[] arr = {7, 12, 45, 6, 7, 45, 45, 8, 6};
        row(arr);
        hooks.printArr(arr);
    }

//    Question 1
    public static void row(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < length; j++)
                if (arr[i] == arr[j]) {
                    hooks.swap(arr, i + count, j);
                    count++;
                }
        }
    }
}
