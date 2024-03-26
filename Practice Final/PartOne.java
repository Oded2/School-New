public class PartOne {
    public static void main(String[] args) {
        int[] arr = {1,8,15,22,36};
        System.out.println(missingNum(arr));
    }

//    Question 1
    public static boolean posOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            if (first > 0) for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                if (second > 0 && second < first) return false;
            }
        }
        return true;
    }

//    Question 2
    public static int missingNum(int[] arr) {
        int dif;
        int dif1 = arr[1] - arr[0];
        int dif2 = arr[2] - arr[1];
        int dif3 = arr[3] - arr[2];
        if (dif1 == dif2) dif = dif1;
        else dif = dif3;
        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int next = arr[i+1];
            if (next - current != dif) return ((current + next) / 2);
        }
        return 0; // Can't actually happen in the test according to the given (נתונים)
    }
}
