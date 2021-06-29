import java.util.Arrays;

class SecondHighest {
    public static void main(String[] args) {
        int arr[] = { 10, 6, 28, 2, 19 };

        // bySort(arr);
        // byDoubleIteration(arr);

        int first = 0;
        int second = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        System.out.println(first + " " + second);
    }

    private static void byDoubleIteration(int[] arr) {
        int len = arr.length;
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            highest = Math.max(highest, arr[i]);
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != highest) {
                second = Math.max(second, arr[i]);
            }
        }

        System.out.println(highest + " " + second);
    }

    private static void bySort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}